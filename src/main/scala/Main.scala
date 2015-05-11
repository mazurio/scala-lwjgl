import org.lwjgl.opengl._
import org.lwjgl.opengl.GL11._

object Main {
  def main(args: Array[String]): Unit = {
    Display.setDisplayMode(new DisplayMode(800, 600))
    Display.create()

    while(!Display.isCloseRequested) {
      Display.update()
      display()
      Display.sync(60)
    }

    Display.destroy()
  }

  def display(): Unit = {
    glClear(GL_COLOR_BUFFER_BIT)
    glRender(GL_TRIANGLES) {
      glColor3f(1.0f, 0.0f, 0.0f)
      glVertex3f(0.0f, 1.0f, 0.0f)
      glColor3f(0.0f, 1.0f, 0.0f)
      glVertex3f(-1.0f, -1.0f, 0.0f)
      glColor3f(0.0f, 0.0f, 1.0f)
      glVertex3f(1.0f, -1.0f, 0.0f)
    }
  }

  def glRender(mode: Int)(block: => Unit): Unit = {
    glBegin(mode)
    block
    glEnd()
  }
}