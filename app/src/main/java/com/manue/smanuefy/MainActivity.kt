package com.manue.smanuefy

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var musica : MediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        val titulos = arrayOf("BushPig", "Diez Cuatro", "Dip and Get Low", "Ella quiere reggaeton", "Fake Capo", "Here I Go", "Highest in the room", "La nota", "Mask off", "Mi niña", "Normal que se lo crea", "Personajes", "Rap flamenco", "Reloj", "Una locura")
        val cantantes = arrayOf("Deekline & Wizard", "V. Aparicio", "Stanton Warriors, Rodney P - Deekline & Wizard Remix", "Daviles de Novelda", "Karetta el Gucci", "V. Aparicio", "Travis Scott", "Manuel Turizo, Rauw Alejandro, Myke Towers", "Future ft. Kendrick Lamar", "Wisin, Myke Towers, Los Legendarios", "Daviles de Novelda, Omar Montes, Rvfv, Keen Levy", "Haze, El Arrebato", "Haze, Canelita", "Rauw Alejandro, Anuel AA", "Ozuna, J Balvin, Chencho Corleone")
        val imageId = arrayOf(R.drawable.bushpig, R.drawable.diez_cuatro, R.drawable.dip_and_get_low, R.drawable.ella_quiere_reggaeton, R.drawable.fake_capo, R.drawable.here_i_go, R.drawable.highest_in_the_room, R.drawable.la_nota, R.drawable.mask_off, R.drawable.mi_ninia, R.drawable.normal_que_se_lo_crea, R.drawable.personajes, R.drawable.rap_flamenco, R.drawable.reloj, R.drawable.una_locura)
        val cancion = arrayOf(R.raw.bushpig, R.raw.diez_cuatro, R.raw.dip_and_get_low, R.raw.ella_quiere_reggaeton, R.raw.fake_capo, R.raw.here_i_go, R.raw.highest_in_the_room, R.raw.la_nota, R.raw.mask_off, R.raw.mi_ninia, R.raw.normal_que_se_lo_crea, R.raw.personajes, R.raw.rap_flamenco, R.raw.reloj, R.raw.una_locura)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button6.setOnClickListener{
            var dialog = DialogFragmentMio()
            dialog.show(supportFragmentManager, "customDialog")
        }

        val myListAdapter = MyListAdapter(this, titulos, cantantes, imageId)
        lista.adapter = myListAdapter

        lista.setOnItemClickListener() { adapterView, view, position, id ->
            var pos = position

            if (musica != null) {
                musica.release()
                musica = MediaPlayer()
            }

            musica = MediaPlayer.create(this, cancion[position])
            textView5.setText(titulos[position])
            textView4.setText(cantantes[position])
            button3.setText("❚❚")
            musica.start()
            initializeSeekBar()

            button4.setOnClickListener(View.OnClickListener {
                if (musica != null) {
                    musica.release()
                    musica = MediaPlayer()
                }
                pos++
                musica = MediaPlayer.create(this, cancion[pos])
                textView5.setText(titulos[pos])
                textView4.setText(cantantes[pos])
                musica.start()
                initializeSeekBar()
            })

            button2.setOnClickListener(View.OnClickListener {
                if (musica != null) {
                    musica.release()
                    musica = MediaPlayer()
                }
                pos--
                musica = MediaPlayer.create(this, cancion[pos])
                textView5.setText(titulos[pos])
                textView4.setText(cantantes[pos])
                musica.start()
                initializeSeekBar()
            })

            button3.setOnClickListener(View.OnClickListener {
                if (musica.isPlaying) {
                    musica.pause()
                    button3.setText("▶")
                }
                else {
                    musica.start()
                    initializeSeekBar()
                    button3.setText("❚❚")
                }
            })

        }
    }

    fun video(view: View?){
        val intent = Intent(this, VideoView::class.java)
        startActivity(intent)
    }

    fun web(view: View?){
        val intent = Intent(this, WebView::class.java)
        startActivity(intent)
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        if (fromUser) musica.seekTo(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        TODO("Not yet implemented")
    }

    private fun initializeSeekBar() {
        seekBar.max = musica.duration
        val handler = Handler()

        handler.postDelayed(object: Runnable {
            override fun run() {
                try {
                    seekBar.progress = musica.currentPosition
                    handler.postDelayed(this, 1000)
                } catch (e:Exception) {
                    seekBar.progress = 0
                }
            } },0)
    }
}