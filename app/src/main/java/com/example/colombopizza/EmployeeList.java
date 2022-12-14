package com.example.colombopizza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EmployeeList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmployeeList extends Fragment {
    ListView listEmployee;
    Button button;
    Employee_list_adapter employee_list_adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EmployeeList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EmployeeList.
     */
    // TODO: Rename and change types and number of parameters
    public static EmployeeList newInstance(String param1, String param2) {
        EmployeeList fragment = new EmployeeList();
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_employee_list, container, false);

        listEmployee = view.findViewById(R.id.listEmployee);
        DB_operation db = new DB_operation(getActivity());


        ArrayList<DB_employee> dbEmployees = db.viewAllEmployees();
        if(dbEmployees!=null) {

            Employee_list_adapter employee_list_adapter = new Employee_list_adapter(getActivity(), dbEmployees);
            listEmployee.setAdapter(employee_list_adapter);
        }else{
            Toast.makeText(getActivity(),"No users",Toast.LENGTH_SHORT).show();
        }



        return view;
    }

}