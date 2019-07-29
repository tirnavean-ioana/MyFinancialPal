package com.example.myfinancialpal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddAmountFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AddAmountFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText value;
    private EditText date;
    private Spinner spinner;
    private Button add_value;
    private Button cancel;

    View rootView;

    public AddAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_add_amount, container, false);

        value = rootView.findViewById(R.id.add_suma);
        date = rootView.findViewById(R.id.add_date);
        spinner = rootView.findViewById(R.id.spinner);
        add_value = rootView.findViewById(R.id.add_button);
        cancel = rootView.findViewById(R.id.cancel_button);

        setSpinnerItems();

        btn_add();
        btn_cancel();



        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setSpinnerItems(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.income_options, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void btn_add(){
        add_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO adauga inregistrarea in baza de date

            }
        });
    }

    private void btn_cancel(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO actiune pentru cancel

            }
        });
    }
}
