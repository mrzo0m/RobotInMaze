package ru.st.training.gui

import ru.st.training.domain.CellState.CellState
import ru.st.training.domain.{CellObserver, CellState}
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color._

class CellView(val canvas: Canvas, val a: Double, val b: Double) extends CellObserver {

  val cellWidth: Double = 40.0

  val cellHeight: Double = 40.0

  override def update(eventType: CellState): Unit = {

    def prepare = {
      val startX = a * cellHeight
      val endX = startX + cellHeight
      val startY = b * cellWidth
      val endY = startY
      canvas.graphicsContext2D.setFill(Black)
      canvas.graphicsContext2D.setStroke(SandyBrown)
      canvas.graphicsContext2D.setLineWidth(1)
      canvas.graphicsContext2D.fillRect(startX -1 ,startY -1, cellWidth, cellHeight)
    }

    eventType match {
      case CellState.AllWallBuilt => {
        prepare
        val startX = a * cellHeight
        val endX = startX + cellHeight
        val startY = b * cellWidth
        val endY = startY
        canvas.graphicsContext2D.strokeLine(startX, startY, endX, endY)
        canvas.graphicsContext2D.strokeLine(startX, startY + cellHeight, endX, endY + cellWidth) //bottom
        canvas.graphicsContext2D.strokeLine(startX + cellHeight, startY, endX, endY + cellWidth) //right
        canvas.graphicsContext2D.strokeLine(startX, startY, startX, endY + cellWidth) //left
      }
      case CellState.TopWallRuin => {
        prepare
        val startX = a * cellHeight
        val endX = startX + cellHeight
        val startY = b * cellWidth
        val endY = startY
        canvas.graphicsContext2D.strokeLine(startX, startY + cellHeight, endX, endY + cellWidth) //bottom
        canvas.graphicsContext2D.strokeLine(startX + cellHeight, startY, endX, endY + cellWidth) //right
        canvas.graphicsContext2D.strokeLine(startX, startY, startX, endY + cellWidth) //left
      }

      case CellState.RightWallRuin => {
        prepare
        val startX = a * cellHeight
        val endX = startX + cellHeight
        val startY = b * cellWidth
        val endY = startY
        canvas.graphicsContext2D.strokeLine(startX, startY, endX, endY)
        canvas.graphicsContext2D.strokeLine(startX, startY + cellHeight, endX, endY + cellWidth) //bottom
        canvas.graphicsContext2D.strokeLine(startX, startY, startX, endY + cellWidth) //left
      }

      case CellState.BottomWallRuin => {
        prepare
        val startX = a * cellHeight
        val endX = startX + cellHeight
        val startY = b * cellWidth
        val endY = startY
        canvas.graphicsContext2D.strokeLine(startX, startY, endX, endY)
        canvas.graphicsContext2D.strokeLine(startX + cellHeight, startY, endX, endY + cellWidth) //right
        canvas.graphicsContext2D.strokeLine(startX, startY, startX, endY + cellWidth) //left
      }

      case CellState.LeftWallRuin => {
        prepare
        val startX = a * cellHeight
        val endX = startX + cellHeight
        val startY = b * cellWidth
        val endY = startY
        canvas.graphicsContext2D.strokeLine(startX, startY, endX, endY)
        canvas.graphicsContext2D.strokeLine(startX, startY + cellHeight, endX, endY + cellWidth) //bottom
        canvas.graphicsContext2D.strokeLine(startX + cellHeight, startY, endX, endY + cellWidth) //right
      }
    }
  }
}
