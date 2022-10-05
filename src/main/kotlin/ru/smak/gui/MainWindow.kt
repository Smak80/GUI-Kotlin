package ru.smak.gui

import java.awt.Color
import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.*
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener

class MainWindow : JFrame() {
    val jsXMin: JSpinner
    val jsXMax: JSpinner
    val nmXMin: SpinnerNumberModel
    val nmXMax: SpinnerNumberModel
    val lblXMin: JLabel
    val lblXMax: JLabel
    val pnlColor1: JPanel
    val minSz = Dimension(600, 450)

    init{
        defaultCloseOperation = EXIT_ON_CLOSE
        minimumSize = minSz
        nmXMin = SpinnerNumberModel(-5.0, -100.0, 4.8, 0.1)
        nmXMax = SpinnerNumberModel( 5.0, -4.8, 100.0, 0.1)
        jsXMin = JSpinner(nmXMin)
        jsXMax = JSpinner(nmXMax)
        jsXMax.addChangeListener{ _ -> nmXMin.maximum = nmXMax.value as Double - 2.0 * nmXMax.stepSize as Double}
        jsXMin.addChangeListener{ _ -> nmXMax.minimum = nmXMin.value as Double + 2.0 * nmXMin.stepSize as Double}
        lblXMin = JLabel()
        lblXMin.text = "Xmin: "
        lblXMax = JLabel()
        lblXMax.text = "Xmax: "

        pnlColor1 = JPanel()
        pnlColor1.background = Color.BLUE
        pnlColor1.addMouseListener(object : MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                JColorChooser.showDialog(
                    this@MainWindow,
                    "Выбор цвета полинома",
                    pnlColor1.background
                )?.let{
                    pnlColor1.background = it
                }
            }
        })

        layout = GroupLayout(contentPane).apply {
            setHorizontalGroup(createSequentialGroup()
                .addGap(8)
                .addGroup(createParallelGroup()
                    .addGroup(createSequentialGroup()
                        .addComponent(lblXMin, SHRINK, SHRINK, SHRINK)
                        .addComponent(jsXMin, 70, SHRINK, SHRINK)
                        .addGap(16)
                        .addComponent(lblXMax, SHRINK, SHRINK, SHRINK)
                        .addComponent(jsXMax, 70, SHRINK, SHRINK)
                    )
                    .addComponent(pnlColor1, 20, 20, 20)
                )
                .addGap(8)
            )

            setVerticalGroup(createSequentialGroup()
                .addGap(8)
                .addGroup(
                    createParallelGroup()
                        .addComponent(lblXMin, SHRINK, SHRINK, SHRINK)
                        .addComponent(jsXMin, SHRINK, SHRINK, SHRINK)
                        .addComponent(lblXMax, SHRINK, SHRINK, SHRINK)
                        .addComponent(jsXMax, SHRINK, SHRINK, SHRINK)
                )
                .addComponent(pnlColor1, 20, 20, 20)
                .addGap(8)
            )
        }
    }

    companion object{
        val SHRINK = GroupLayout.PREFERRED_SIZE
        val GROW = GroupLayout.DEFAULT_SIZE
    }
}