package atmconsultoria.cursoandroid.com.atmconsultoria.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atmconsultoria.cursoandroid.com.atmconsultoria.R;


public class ServicosFragment extends Fragment {


    public ServicosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_servicos, container, false);
    }

}
