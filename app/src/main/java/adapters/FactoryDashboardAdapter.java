package adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import example.com.industrialautomation.R;
import models.FactoryDashboard;

/**
 * Created by kumardev on 2/3/2017.
 */

public class FactoryDashboardAdapter extends RecyclerView.Adapter<FactoryDashboardAdapter.FactoryViewHolder> implements View.OnClickListener {

    private LinearLayout layoutOne,layoutTwo;

    List<FactoryDashboard> factoryDashboards;
    public FactoryDashboardAdapter(List<FactoryDashboard> factoryDashboards) {
                this.factoryDashboards=factoryDashboards;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    @Override
    public FactoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.factory_card, parent, false);
        FactoryViewHolder factoryView = new FactoryViewHolder(v);
        return factoryView;

    }

    @Override
    public void onBindViewHolder(final FactoryViewHolder holder, int position) {
        holder.status.setText(factoryDashboards.get(position).getStatus());
        holder.power_consumption.setText(factoryDashboards.get(position).getPower_consumption());
        holder.temp.setText(factoryDashboards.get(position).getTemp());
        holder.humidity.setText(factoryDashboards.get(position).getHumidity());
        layoutOne=holder.linearDetail;
        layoutTwo=holder.linearRealDevices;
        holder.linearDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.linearRealDevices.getVisibility()==View.VISIBLE){
                    holder.linearRealDevices.setVisibility(View.GONE);
                }else {
                    holder.linearRealDevices.setVisibility(View.VISIBLE);
                }
            }
        });


    }



    @Override
    public int getItemCount() {
        return factoryDashboards.size();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.linearDetails:

                if(layoutTwo.getVisibility()==View.VISIBLE){
                   layoutTwo.setVisibility(View.GONE);
                }else {
                   layoutTwo.setVisibility(View.VISIBLE);
                }

                break;
        }
    }

    public static class FactoryViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView status,power_consumption,temp,humidity;
        LinearLayout linearDetail,linearRealDevices;

        FactoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.factoryCard);
            status = (TextView)itemView.findViewById(R.id.tvFactoryStatus);
            power_consumption = (TextView)itemView.findViewById(R.id.tvPowerConsumption);
            temp = (TextView)itemView.findViewById(R.id.tvTemp);
            humidity = (TextView)itemView.findViewById(R.id.tvHumidity);
            linearDetail= (LinearLayout)itemView.findViewById(R.id.linearDetails);
            linearRealDevices= (LinearLayout) itemView.findViewById(R.id.linearRealDevices);
        }
    }
}
