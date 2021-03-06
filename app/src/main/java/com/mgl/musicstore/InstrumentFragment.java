package com.mgl.musicstore;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.mgl.musicstore.bd.InstrumentController;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InstrumentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InstrumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InstrumentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Integer[] thumbsId = {
            R.drawable.instru_1,
            R.drawable.instru_2,
            R.drawable.instru_3,
            R.drawable.instru_4,
            R.drawable.instru_5,
            R.drawable.instru_6,
    };
    private GridView gridView;

    private OnFragmentInteractionListener mListener;

    public InstrumentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InstrumentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InstrumentFragment newInstance(String param1, String param2) {
        InstrumentFragment fragment = new InstrumentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_instrument, container, false);

        gridView = (GridView) rootView.findViewById(R.id.gridview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.3.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InstrumentService service = retrofit.create(InstrumentService.class);

        final Call<List<Instrument>> instrumentCall = service.getAll();

        instrumentCall.enqueue(new Callback<List<Instrument>>() {
            @Override
            public void onResponse(@NonNull Call<List<Instrument>> call, @NonNull Response<List<Instrument>> response) {
                if (response.isSuccessful()) {
                    List<Instrument> list = response.body();

                    InstrumentController instrumentController = new InstrumentController(getActivity());
                    for (Instrument instrument : list) {
                        if (instrumentController.findById(instrument.getId()) == null) {
                            instrumentController.save(instrument);
                        }
                    }
                    Cursor cursor = instrumentController.getAll();
                    //  public Instrument(int id, String modelo, String marca, String cor, String categoria, double preco) {
                    list = new ArrayList<>();

                    while (cursor.moveToNext()) {
                        list.add(new Instrument(
                                cursor.getColumnIndex("_id"),
                                cursor.getString(cursor.getColumnIndex("modelo")),
                                cursor.getString(cursor.getColumnIndex("marca")),
                                cursor.getString(cursor.getColumnIndex("cor")),
                                cursor.getString(cursor.getColumnIndex("categoria")),
                                cursor.getDouble(cursor.getColumnIndex("preco"))
                                ));
                    }

                    gridView.setAdapter(new InstrumentAdapter(getActivity(), list));

                }
            }

            @Override
            public void onFailure(Call<List<Instrument>> call, Throwable t) {
                System.out.println(t.getMessage());
                t.printStackTrace();
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Instrument instrument = (Instrument) adapterView.getItemAtPosition(i);

                Intent it = new Intent(getActivity(), OfferActivity.class);
                it.putExtra("id", instrument.getId());
                it.putExtra("modelo", instrument.getModelo());
                it.putExtra("marca", instrument.getMarca());
                it.putExtra("preco", instrument.getPreco());
                it.putExtra("cor", instrument.getCor());
                startActivity(it);
            }
        });

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
//            Toast.makeText(context, "Instrument Fragment Attach", Toast.LENGTH_SHORT).show();
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
}
