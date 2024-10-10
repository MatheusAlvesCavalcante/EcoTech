package br.com.local.ecotech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import br.com.local.ecotech.placeholder.EcoPontoModel;

import java.util.List;

public class MyEcoPontoRecyclerViewAdapter extends
        RecyclerView.Adapter<MyEcoPontoRecyclerViewAdapter.ViewHolder> {

    private final List<EcoPontoModel> mValues;
    private final ListaEcoPontos.OnListFragmentInteractionListener mListener;

    public MyEcoPontoRecyclerViewAdapter(List<EcoPontoModel> items,
                                         ListaEcoPontos.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_produto, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mBairroView.setText(mValues.get(position).bairro);
        holder.mNomeView.setText(mValues.get(position).nome);

        if(mValues.get(position).foto != null)
            holder.mImagemPerfilView.setImageBitmap(Util.converterByteToBipmap(mValues.get(position).foto));

        holder.mViewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    Snackbar.make(v, "OLA", Snackbar.LENGTH_LONG);

                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//
//                    Toast.makeText(v.getContext(), "OLA", Toast.LENGTH_LONG);
//                    // Notify the active callbacks interface (th activity, if the fragment is attached to one) that an item has been selected.
//                    // mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return mValues.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final AppCompatTextView mBairroView;
        public final AppCompatTextView mNomeView;
        public final AppCompatImageView mImagemPerfilView;
        public final AppCompatButton mViewDetailsButton;
        public EcoPontoModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mBairroView = (AppCompatTextView)
                    view.findViewById(R.id.bairro);
            mNomeView = (AppCompatTextView)
                    view.findViewById(R.id.nome);
            mImagemPerfilView = (AppCompatImageView)
                    view.findViewById(R.id.imagem_perfil);
            mViewDetailsButton = (AppCompatButton) view.findViewById(R.id.view_details);
        }
        @Override
        public String toString() {
            return super.toString() + " '" + mNomeView.getText()
                    + "'";

        }
    }


}
