import java.awt.Dimension
import java.awt.Point
import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

class MainWindow : JFrame() {
    val minSize = Dimension(600, 450)

    val btn = JButton()
    val tf = JTextField()
    val lblResult = JLabel()

    init{
        size = minSize
        defaultCloseOperation = EXIT_ON_CLOSE

        btn.text = "Нажми меня"
        lblResult.text = "Здесь будет текст пользователя"

        val gl = GroupLayout(contentPane)
        layout = gl

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGap(8)
            .addComponent(tf, 25, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, Int.MAX_VALUE)
            .addComponent(btn, 25, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, Int.MAX_VALUE)
            .addComponent(lblResult, 25, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(8)
        )

        gl.setHorizontalGroup(gl.createSequentialGroup()
            .addGap(8)
            .addGroup(gl.createParallelGroup()
            .addComponent(tf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGroup(gl.createSequentialGroup()
                    .addGap(8, 8, Int.MAX_VALUE)
                    .addComponent(btn, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, Int.MAX_VALUE)
                )
            .addComponent(lblResult, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
            )
            .addGap(8)
        )
    }
}