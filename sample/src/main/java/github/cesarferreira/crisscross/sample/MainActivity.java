package github.cesarferreira.crisscross.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.cesarferreira.crisscross.CrissCross;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.sample_criss_cross)
    CrissCross crissCross;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.sample_criss_cross)
    public void tap() {
        crissCross.toggle();
    }

    @OnClick(R.id.minusButton)
    public void minus() {
        crissCross.animate(0, 0);
    }

    @OnClick(R.id.plusButton)
    public void plus() {
        crissCross.animate(90, 180);
    }

    @OnClick(R.id.crossButton)
    public void cross() {
        crissCross.animate(225.0, -45);
    }


}
