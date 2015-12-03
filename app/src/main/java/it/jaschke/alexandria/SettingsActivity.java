package it.jaschke.alexandria;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * Created by saj on 27/01/15.
 */
public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener{

    private ListPreference pref_startFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);


        pref_startFragment= (ListPreference)findPreference("pref_startFragment");
        pref_startFragment.setOnPreferenceChangeListener(this);

        pref_startFragment.setSummary(pref_startFragment.getEntry());
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if(preference == pref_startFragment){

//            pref_startFragment.setSummary(tempp[Integer.parseInt(newValue.toString())]);
            final int idx = pref_startFragment.findIndexOfValue((String)newValue);
            pref_startFragment.setSummary(pref_startFragment.getEntries()[idx]);
            return true;
        }
        return false;

    }
}
