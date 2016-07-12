package in.silive.happybirthday;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.MediaPlayer;


/**
 * A simple {@link Fragment} subclass.
 */
public class Akriti extends Fragment {


    public Akriti() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view=inflater.inflate(R.layout.fragment_akriti, container, false);
        final MediaPlayer mp=MediaPlayer.create(getContext(),R.raw.aud1);
        mp.start();
        return view;
    }

}
