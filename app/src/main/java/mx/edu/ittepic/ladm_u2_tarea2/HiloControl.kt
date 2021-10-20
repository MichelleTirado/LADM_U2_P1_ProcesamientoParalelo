package mx.edu.ittepic.ladm_u2_tarea2

import android.app.AlertDialog
import android.graphics.Canvas
import android.graphics.Paint

class HiloControl(p:MainActivity):Thread(){
    var puntero = p
    var pausa = false
    var vivo = true
    override fun run() {
        super.run()
        while(vivo){
            if(!pausa){

                sleep(100)
                puntero.lienzo!!.imagenDibujo = puntero.lienzo!!.imagen4
                puntero.lienzo!!.invalidate()


                sleep(100)
                  puntero.lienzo!!.imagenDibujo = puntero.lienzo!!.imagen3
                puntero.lienzo!!.invalidate()


                sleep(100)
                puntero.lienzo!!.imagenDibujo = puntero.lienzo!!.imagen2
                puntero.lienzo!!.invalidate()
                puntero.x += 15
            }



        }
    }

    fun despausar(){
        pausa = false
    }

    fun pausar(){
        pausa = true
    }

    fun estaPausado():Boolean{
        return pausa
    }

    fun detenerHilo(){
        vivo = false
    }

    fun reiniciarHilo(){
        puntero.x = 0
    }
}

