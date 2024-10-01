package br.com.local.ecotech;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import br.com.local.ecotech.placeholder.ProdutoContent;


public class Teste extends AppCompatActivity {
    implements ProdutoFragment.OnListFragmentInteractionListener

    {
        private TextView mTextMessage;
        private BottomNavigationView.OnNavigationItemSelectedListener
                mOnNavigationItemSelectedListener
                = new
                BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem
                                                                    item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                mTextMessage.setText(R.string.title_home);
                                return true;
                            case R.id.navigation_produtos:
                                mTextMessage.setText(R.string.title_produtos);
                                FragmentTransaction ft =
                                        getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.fragment_container, new
                                                ProdutoFragment())
                                        .addToBackStack(null)
                                        .commit();

                                return true;
                            case R.id.navigation_login:
                                mTextMessage.setText(R.string.title_login);
                                return true;
                        }
                        return false;
                    }
                };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView)
                findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
        @Override
        public void onListFragmentInteraction(ProdutoContent.ProdutoItem
        item) {
    }
    }
}

