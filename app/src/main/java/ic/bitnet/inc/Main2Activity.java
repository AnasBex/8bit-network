package ic.bitnet.inc;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class Main2Activity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String backgroundColor = "";
	private double X = 0;
	private double Y = 0;
	
	private LinearLayout linear1;
	private LinearLayout status_bar;
	private LinearLayout toolbar;
	
	private PopupWindow Fab;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main2);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		linear1 = findViewById(R.id.linear1);
		status_bar = findViewById(R.id.status_bar);
		toolbar = findViewById(R.id.toolbar);
	}
	
	private void initializeLogic() {
		_extra();
	}
	
	public void _extra() {
		//* Status Bar*//
		_toolbar.setBackgroundColor(Color.TRANSPARENT);
		
		Window window = this.getWindow();
		
		  if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			
			((ViewGroup)_toolbar.getParent()).removeView(_toolbar);
			toolbar.addView(_toolbar);
			
			int statusBar = getResources().getIdentifier("status_bar_height", "dimen", "android");
			if (statusBar > 0) {
				status_bar.getLayoutParams().height = getResources().getDimensionPixelSize(statusBar); }
			
		}
		X = 10;
		Y = 10;
		View FabV = getLayoutInflater().inflate(R.layout.fab_model, null);
		final PopupWindow Fab = new PopupWindow(FabV, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
		final LinearLayout liFab_fab = FabV.findViewById(R.id.liFab);
		com.google.android.material.floatingactionbutton.FloatingActionButton liFab = new com.google.android.material.floatingactionbutton.FloatingActionButton(Main2Activity.this);
		liFab_fab.addView(liFab);
		Fab.setAnimationStyle(android.R.style.Animation_Dialog);
		Fab.showAsDropDown(_fab, (int) X,(int) Y);
		Fab.setBackgroundDrawable(new BitmapDrawable());
		_roundedAndRipple(liFab, "#616161", "#BDBDBD", 50);
		liFab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Fab.dismiss();
			}
		});
	}
	
	
	public void _roundedAndRipple(final View _view, final String _backgroundColor, final String _rippleColor, final double _radius) {
		//Code from StackOverflow and adapted for Sketchware by @BOFA 
		//Please do not reupload. If you want to improve, feel free just give credit.
		
		//For colors include #
		
		if (_backgroundColor.equals("")) {
			//If you leave the background color empty, it will be set to this default color.
			backgroundColor = "#FFFFFF";
		}
		else {
			backgroundColor = _backgroundColor;
		}
		android.content.res.ColorStateList pressedStates = android.content.res.ColorStateList.valueOf(Color.parseColor(_rippleColor)); 
		//adapted for Sketchware by BOFA
		android.graphics.drawable.GradientDrawable contentDrawable = new android.graphics.drawable.GradientDrawable();
		contentDrawable.setColor(Color.parseColor(backgroundColor));
		if (!(_radius == 0)) {
			//If you leave radius empty, no radius will be added.
			contentDrawable.setCornerRadius((int)_radius);
		}
		android.graphics.drawable.RippleDrawable rippleDrawable = new android.graphics.drawable.RippleDrawable(pressedStates, contentDrawable, null);
		//
		_view.setBackground(rippleDrawable);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}