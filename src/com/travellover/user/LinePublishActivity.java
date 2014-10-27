package com.travellover.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.travellover.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

public class LinePublishActivity extends Activity implements OnPageChangeListener {

	private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private TextView t1, t2;// 页卡头标
    private Button closePlaceBtn;
    private ImageButton singleImageBtn;
    private ImageButton doubleImageBtn;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private String dateString;
    private String timeString;
    private Button closeTimeBtn;
    private Button farTimeBtn;
    private TextView closeNumber;
    private TextView farNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.line_publish);
		Button linePublishBackBtn = (Button)findViewById(R.id.linePublishBackBtn);
		linePublishBackBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		closePlaceBtn = (Button)findViewById(R.id.closePlaceBtn);
		closePlaceBtn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Builder headshotSelect = new AlertDialog.Builder(LinePublishActivity.this);
				headshotSelect.setTitle("更换城市");
				headshotSelect.setItems(new String[]{"杭州", "广州", "深圳", "取消"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						switch(arg1) {
						case 0:
							closePlaceBtn.setText("杭州");
							break;
						case 1:
							closePlaceBtn.setText("广州");
							break;
						case 2:
							closePlaceBtn.setText("深圳");
							break;
						}
					}
					
				});
				headshotSelect.show();
			}
			
		});
		mPager = (ViewPager) findViewById(R.id.vPager);
        listViews = new ArrayList<View>();
        LayoutInflater mInflater = getLayoutInflater();
        listViews.add(mInflater.inflate(R.layout.linepublish_close, null));
        listViews.add(mInflater.inflate(R.layout.linepublish_far, null));
        
        PagerAdapter pa=new PagerAdapter(){
        	
            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return listViews.size();
            }

            @Override
            public void destroyItem(View container, int position, Object object) {
                // TODO Auto-generated method stub
                ((ViewPager)container).removeView(listViews.get(position));
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0==arg1;
            }

            @Override
            public void finishUpdate(View arg0) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Object instantiateItem(View arg0, int arg1) {
                // TODO Auto-generated method stub
                ((ViewPager)arg0).addView(listViews.get(arg1),0);
                if(arg1 == 1) {
                	singleImageBtn = (ImageButton)findViewById(R.id.singleImageBtn);
            		Button singleBtn = (Button)findViewById(R.id.singleBtn);
            		doubleImageBtn = (ImageButton)findViewById(R.id.doubleImageBtn);
            		Button doubleBtn = (Button)findViewById(R.id.doubleBtn);
            		singleImageBtn.setOnClickListener(new OnClickListener(){

            			@Override
            			public void onClick(View arg0) {
            				// TODO Auto-generated method stub
            				singleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_p));
            				doubleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_n));
            			}
            			
            		});
            		singleBtn.setOnClickListener(new OnClickListener(){

            			@Override
            			public void onClick(View arg0) {
            				// TODO Auto-generated method stub
            				singleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_p));
            				doubleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_n));
            			}
            			
            		});
            		doubleImageBtn.setOnClickListener(new OnClickListener(){

            			@Override
            			public void onClick(View arg0) {
            				// TODO Auto-generated method stub
            				doubleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_p));
            				singleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_n));
            			}
            			
            		});
            		doubleBtn.setOnClickListener(new OnClickListener(){

            			@Override
            			public void onClick(View arg0) {
            				// TODO Auto-generated method stub
            				doubleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_p));
            				singleImageBtn.setImageDrawable(getResources().getDrawable(R.drawable.ic_checkbox_n));
            			}
            			
            		});
            		closeTimeBtn = (Button)findViewById(R.id.closeTimeBtn);
            		closeTimeBtn.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater.inflate(R.layout.time_component,null);
							datePicker = (DatePicker)layout.findViewById(R.id.datePicker);
							timePicker = (TimePicker)layout.findViewById(R.id.timePicker);
							timePicker.setIs24HourView(true);
							Builder builder = new AlertDialog.Builder(LinePublishActivity.this);
							SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat sDateFormat2 = new SimpleDateFormat("HH:mm");
							dateString = sDateFormat1.format(new java.util.Date());
							timeString = sDateFormat2.format(new java.util.Date());
							Calendar calendar=Calendar.getInstance();
					        int year=calendar.get(Calendar.YEAR);
					        int monthOfYear=calendar.get(Calendar.MONTH);
					        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
					        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){

								@Override
								public void onDateChanged(DatePicker arg0,
										int arg1, int arg2, int arg3) {
									// TODO Auto-generated method stub
									dateString = arg1 + "-" + arg2 + "-" + arg3;
								}
					        	
					        });
					        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
								
								@Override
								public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
									// TODO Auto-generated method stub
									timeString = arg1 + ":" + arg2;
								}
							});
							builder.setTitle(dateString + " " + timeString).setView(layout)
							.setPositiveButton("设置", new DialogInterface.OnClickListener(){

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									closeTimeBtn.setText(dateString + " " + timeString);
								}
								
							})
							.setNegativeButton("取消", null).show();
						}
            			
            		});
            		closeNumber = (TextView)findViewById(R.id.numberCloseOfPeople);
            		ImageButton closeAddBtn = (ImageButton)findViewById(R.id.closeAddBtn);
            		ImageButton closeMinusBtn = (ImageButton)findViewById(R.id.closeMinusBtn);
            		closeAddBtn.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							int num = Integer.parseInt(closeNumber.getText().toString());
							closeNumber.setText(num + 1 + "");
						}
            			
            		});
            		closeMinusBtn.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							int num = Integer.parseInt(closeNumber.getText().toString());
							if(num > 1){
								closeNumber.setText(num - 1 + "");
							}
						}
            			
            		});
                
                
	                farTimeBtn = (Button)findViewById(R.id.farTimeBtn);
	                farTimeBtn.setOnClickListener(new OnClickListener(){
	
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							LayoutInflater inflater = getLayoutInflater();
							View layout = inflater.inflate(R.layout.time_component,null);
							datePicker = (DatePicker)layout.findViewById(R.id.datePicker);
							timePicker = (TimePicker)layout.findViewById(R.id.timePicker);
							timePicker.setIs24HourView(true);
							Builder builder = new AlertDialog.Builder(LinePublishActivity.this);
							SimpleDateFormat sDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat sDateFormat2 = new SimpleDateFormat("HH:mm");
							dateString = sDateFormat1.format(new java.util.Date());
							timeString = sDateFormat2.format(new java.util.Date());
							Calendar calendar=Calendar.getInstance();
					        int year=calendar.get(Calendar.YEAR);
					        int monthOfYear=calendar.get(Calendar.MONTH);
					        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
					        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){
	
								@Override
								public void onDateChanged(DatePicker arg0,
										int arg1, int arg2, int arg3) {
									// TODO Auto-generated method stub
									dateString = arg1 + "-" + arg2 + "-" + arg3;
								}
					        	
					        });
					        timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
								
								@Override
								public void onTimeChanged(TimePicker arg0, int arg1, int arg2) {
									// TODO Auto-generated method stub
									timeString = arg1 + ":" + arg2;
								}
							});
							builder.setTitle(dateString + " " + timeString).setView(layout)
							.setPositiveButton("设置", new DialogInterface.OnClickListener(){
	
								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									farTimeBtn.setText(dateString + " " + timeString);
								}
								
							})
							.setNegativeButton("取消", null).show();
						}
	        			
	        		});
	                farNumber = (TextView)findViewById(R.id.numberFarOfPeople);
            		ImageButton farAddBtn = (ImageButton)findViewById(R.id.farAddBtn);
            		ImageButton farMinusBtn = (ImageButton)findViewById(R.id.farMinusBtn);
            		farAddBtn.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							int num = Integer.parseInt(farNumber.getText().toString());
							farNumber.setText(num + 1 + "");
						}
            			
            		});
            		farMinusBtn.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							int num = Integer.parseInt(farNumber.getText().toString());
							if(num > 1){
								farNumber.setText(num - 1 + "");
							}
						}
            			
            		});
            		Button newLinePublishCloseBtn = (Button)findViewById(R.id.newLinePublishCloseBtn);
                    newLinePublishCloseBtn.setOnClickListener(new OnClickListener(){

    					@Override
    					public void onClick(View arg0) {
    						// TODO Auto-generated method stub
    						finish();
    					}
                    	
                    });
                    Button newLinePublishFarBtn = (Button)findViewById(R.id.newLinePublishFarBtn);
                    newLinePublishFarBtn.setOnClickListener(new OnClickListener(){

    					@Override
    					public void onClick(View arg0) {
    						// TODO Auto-generated method stub
    						finish();
    					}
                    	
                    });
                }
                
                
                return listViews.get(arg1);
            }

            @Override
            public void restoreState(Parcelable arg0, ClassLoader arg1) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public Parcelable saveState() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public void startUpdate(View arg0) {
                // TODO Auto-generated method stub
                
            }
        };
        
        mPager.setAdapter(pa);
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if(arg0 == 1) {
					closePlaceBtn.setVisibility(Button.INVISIBLE);
				}
				else if(arg0 == 0) {
					closePlaceBtn.setVisibility(Button.VISIBLE);
				}
			}
        	
        });
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
