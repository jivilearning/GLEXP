package jojo.com.jivi;

/*This alphabet code and its drawable (.gif) and raw (.ogg/sound) assets are taken from Amaiya's Alphabet written by emagine! technologies, llc. It's use for the GLEXP is authorized by Leshell Hatley.*/

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class alphabetActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
    }

    public void letter_pressed(View view) {
        Context context = getApplicationContext();
        String text = getResources().getResourceName(view.getId());
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        switch(view.getId()) {
            case R.id.letter_a_btn:
                mp = MediaPlayer.create(this, R.raw.a);
                break;
            case R.id.letter_b_btn:
                mp = MediaPlayer.create(this, R.raw.b);
                break;
            case R.id.letter_c_btn:
                mp = MediaPlayer.create(this, R.raw.c);
                break;
            case R.id.letter_d_btn:
                mp = MediaPlayer.create(this, R.raw.d);
                break;
            case R.id.letter_e_btn:
                mp = MediaPlayer.create(this, R.raw.e);
                break;
            case R.id.letter_f_btn:
                mp = MediaPlayer.create(this, R.raw.f);
                break;
            case R.id.letter_g_btn:
                mp = MediaPlayer.create(this, R.raw.g);
                break;
            case R.id.letter_h_btn:
                mp = MediaPlayer.create(this, R.raw.h);
                break;
            case R.id.letter_i_btn:
                mp = MediaPlayer.create(this, R.raw.i);
                break;
            case R.id.letter_j_btn:
                mp = MediaPlayer.create(this, R.raw.j);
                break;
            case R.id.letter_k_btn:
                mp = MediaPlayer.create(this, R.raw.k);
                break;
            case R.id.letter_l_btn:
                mp = MediaPlayer.create(this, R.raw.l);
                break;
            case R.id.letter_m_btn:
                mp = MediaPlayer.create(this, R.raw.m);
                break;
            case R.id.letter_n_btn:
                mp = MediaPlayer.create(this, R.raw.n);
                break;
            case R.id.letter_o_btn:
                mp = MediaPlayer.create(this, R.raw.o);
                break;
            case R.id.letter_p_btn:
                mp = MediaPlayer.create(this, R.raw.p);
                break;
            case R.id.letter_q_btn:
                mp = MediaPlayer.create(this, R.raw.q);
                break;
            case R.id.letter_r_btn:
                mp = MediaPlayer.create(this, R.raw.r);
                break;
            case R.id.letter_s_btn:
                mp = MediaPlayer.create(this, R.raw.s);
                break;
            case R.id.letter_t_btn:
                mp = MediaPlayer.create(this, R.raw.t);
                break;
            case R.id.letter_u_btn:
                mp = MediaPlayer.create(this, R.raw.u);
                break;
            case R.id.letter_v_btn:
                mp = MediaPlayer.create(this, R.raw.v);
                break;
            case R.id.letter_w_btn:
                mp = MediaPlayer.create(this, R.raw.w);
                break;
            case R.id.letter_x_btn:
                mp = MediaPlayer.create(this, R.raw.x);
                break;
            case R.id.letter_y_btn:
                mp = MediaPlayer.create(this, R.raw.y);
                break;
            case R.id.letter_z_btn:
                mp = MediaPlayer.create(this, R.raw.z);
                break;
            default:
                return;
        }

        mp.start();
        while (mp.isPlaying()) {
            // do nothing
        }
        mp.release();
    }
    public void backToMain(View view) {
        Intent intent = new Intent (alphabetActivity.this,MainActivity.class);
        startActivity(intent);
    }

}

