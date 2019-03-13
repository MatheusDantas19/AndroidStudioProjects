package fragments.cursoandroid.com.fragments.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fragments.cursoandroid.com.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContatosFragment extends Fragment {
    private TextView contato;

    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //inflater, arquivo xml para view
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);
        contato = view.findViewById(R.id.textoContato);
        contato.setText("Contato Alterado");
        return view;
    }

}
