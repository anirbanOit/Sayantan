package com.oit.san.autocomplete;



import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by OPTLPTP119 on 29-08-2017.
 */

public class GeoAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private static final int MAX_RESULTS = 10;
    private Context mContext;
    private List resultList = new ArrayList();

    public GeoAutoCompleteAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public Object getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.geo_search_result, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.geo_search_result_text)).setText(getItem(position)..getAddress());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    List locations = findLocations(mContext, constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = locations;
                    filterResults.count = locations.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (true) {
                    resultList = (List) results.values;
                    notifyDataSetChanged();
                }
                else{
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

    private List<GeoSearchResult> findLocations(Context context, String query_text) {

        List<GeoSearchResult> geo_search_results = new ArrayList<GeoSearchResult>();

        Geocoder geocoder = new Geocoder(context, context.getResources().getConfiguration().locale);
        List<Address> addresses = null;

        try {
            // Getting a maximum of 15 Address that matches the input text
            addresses = geocoder.getFromLocationName(query_text, 15);

            for(int i=0;i<addresses.size();i++){
                Address address = (Address) addresses.get(i);
                if(address.getMaxAddressLineIndex() != -1)
                {
                    geo_search_results.add(new GeoSearchResult(address));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return geo_search_results;
    }
}