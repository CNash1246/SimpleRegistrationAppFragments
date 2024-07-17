package edu.uncc.SimpleRegistrationApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.uncc.SimpleRegistrationApp.fragments.DemographicFragment;
import edu.uncc.SimpleRegistrationApp.fragments.IdentificationFragment;
import edu.uncc.SimpleRegistrationApp.fragments.MainFragment;
import edu.uncc.SimpleRegistrationApp.fragments.ProfileFragment;
import edu.uncc.SimpleRegistrationApp.fragments.Response;
import edu.uncc.SimpleRegistrationApp.fragments.SelectEducationFragment;
import edu.uncc.SimpleRegistrationApp.fragments.SelectIncomeFragment;
import edu.uncc.SimpleRegistrationApp.fragments.SelectLivingStatusFragment;
import edu.uncc.SimpleRegistrationApp.fragments.SelectMaritalStatusFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener,
        IdentificationFragment.IdentificationListener, DemographicFragment.DemographicListener, SelectEducationFragment.SelectEducationListener
        , SelectMaritalStatusFragment.SelectMaritalStatusListener, SelectLivingStatusFragment.SelectLivingStatusListener, SelectIncomeFragment.SelectIncomeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.rootView,new MainFragment())
                .commit();
    }

    @Override
    public void goToIdentificationFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,new IdentificationFragment())
                .commit();
    }

    @Override
    public void goToDemographic(Response response) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView,DemographicFragment.newInstance(response), "fragment_demographic")
                .commit();
    }

    @Override
    public void goToEducation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectEducationFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToMaritalStatus() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectMaritalStatusFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToLivingStatus() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectLivingStatusFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToIncome() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new SelectIncomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToProfile(Response response) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ProfileFragment.newInstance(response))
                .commit();
    }

    @Override
    public void sendEducation(String education) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("fragment_demographic");
        if(fragment != null){
            fragment.setSelectedEducation(education);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelEducation() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendMaritalStatus(String maritalStatus) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("fragment_demographic");
        if(fragment != null){
            fragment.setMaritalStatus(maritalStatus);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelMaritalStatus() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendLivingStatus(String livingStatus) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("fragment_demographic");
        if(fragment != null){
            fragment.setLivingStatus(livingStatus);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelLivingStatus() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void sendIncome(String income) {
        DemographicFragment fragment = (DemographicFragment) getSupportFragmentManager().findFragmentByTag("fragment_demographic");
        if(fragment != null){
            fragment.setIncome(income);
        }
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void cancelIncome() {
        getSupportFragmentManager().popBackStack();
    }
}