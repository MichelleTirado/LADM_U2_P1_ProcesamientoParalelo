package mx.edu.ittepic.ladm_u2_tarea2

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.media.Image


class Lienzo(p:MainActivity) : View(p) {
    var puntero = p
    var incX = puntero.x
    var imagenDibujo = context.resources.getDrawable(R.drawable.img1)

    var imagen2 = context.resources.getDrawable(R.drawable.img2)
    var imagen3 = context.resources.getDrawable(R.drawable.img3)
    var imagen4 = context.resources.getDrawable(R.drawable.img1)
    var imagen5 = context.resources.getDrawable(R.drawable.img4)

    var pausar = context.resources.getDrawable(R.drawable.pausar)
    var despausar = context.resources.getDrawable(R.drawable.despausar)
    var reiniciar = context.resources.getDrawable(R.drawable.reiniciar)
    var detener = context.resources.getDrawable(R.drawable.detener)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint = Paint()
        canvas.drawColor(Color.rgb(243,242,231))
        if(!puntero.hilo.isAlive){
            canvas.drawColor(Color.BLACK)
            imagenDibujo = imagen5
        }
        var ancho = imagenDibujo.intrinsicWidth
        var alto = imagenDibujo.intrinsicHeight

        imagenDibujo.setBounds(0+puntero.x,340,ancho+puntero.x,alto+340)
        imagenDibujo.draw(canvas)

        var anchoP = pausar.intrinsicWidth
        var altoP = pausar.intrinsicHeight
        pausar.setBounds(10,1450,anchoP,altoP+1500)
        pausar.draw(canvas)

        var anchoD = despausar.intrinsicWidth
        var altoD = despausar.intrinsicHeight
        despausar.setBounds(10+anchoP,1450,anchoD+anchoP,altoD+1500)
        despausar.draw(canvas)

        var anchoR = reiniciar.intrinsicWidth
        var altoR = reiniciar.intrinsicHeight
        reiniciar.setBounds(10,1450+altoD+60,anchoR,1450+altoD+altoR+100)
        reiniciar.draw(canvas)

        canvas.drawCircle(100f,100f,40f,paint)


    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        puntero.setTitle("")
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

                puntero.setTitle("Se detuvo")
               // puntero.hilo.detenerHilo()
                // invalidate()


                if(event.x.toInt()>50 && event.x.toInt()<400){
                    if(event.y.toInt()>1450 && event.y.toInt()<1640){
                            puntero.hilo.pausar()
                    }
                }

                if(event.x.toInt()>470 && event.x.toInt()<800){
                    if(event.y.toInt()>1450 && event.y.toInt()<1640){
                        puntero.hilo.despausar()
                    }
                }

                if(event.x.toInt()>50 && event.x.toInt()<400){
                    if(event.y.toInt()>1700 && event.y.toInt()<1800){
                        puntero.hilo.reiniciarHilo()
                    }

                }


            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {
                //puntero.setTitle(event.x.toString() +","+event.y.toString())
            }
        }
        invalidate()
        return true
    }


}