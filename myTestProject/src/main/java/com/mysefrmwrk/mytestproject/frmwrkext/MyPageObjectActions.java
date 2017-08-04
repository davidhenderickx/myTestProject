package com.mysefrmwrk.mytestproject.frmwrkext;

import com.mysefrmwrk.sefrmwrk.helper.PageObjectActions;
import com.mysefrmwrk.sefrmwrk.reports.MasterReporter;
import com.mysefrmwrk.sefrmwrk.reports.Reporter;

public class MyPageObjectActions extends PageObjectActions {

	private static Reporter reporter = new MasterReporter(MyPageObjectActions.class.getName());

}
