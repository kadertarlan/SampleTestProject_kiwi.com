package com.sampleTest.Ids;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sampleTest.config.ConfigPage;

public class MainPageIds extends ConfigPage{

	public MainPageIds(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public By LOGOKIWI =  By.cssSelector("ul.NavbarLogo");
    public By SEARCHFORM =  By.className("SearchForm");
    public By SEARCHFORMMODES =  By.className("SearchFormModes");
    public By SEARCHPASSENGERFIELD =  By.className("PassengersField");
    public By ONEWAY =  By.cssSelector("div.SearchFormModesPicker > div.RadioButtons > label.RadioButtonsOption:first-child");
    public By SEARCHFORMONEWAY =  By.className("SearchFormOneWayReturn");
    public By INPUTPLACESORIGIN  = By.cssSelector("div.SearchForm-content-fields.SearchFormOneWayReturn > fieldset.SearchPlaceField.origin > div.spShadow-half > div > div > div > input");
    public By INPUTPLACESDESTINATION  = By.cssSelector("div.SearchForm-content-fields.SearchFormOneWayReturn > fieldset.SearchPlaceField.destination > div.spShadow-half > div > div > div > input");
    public By SEARCHPLACEFIELD =  By.className("SearchPlaceField");
    public By SEARCHDATEFIELD =  By.className("SearchDateField");

    public By RESULTS = By.className("Results");
    public By LOADINGBAR = By.className("LoadingBar");
    public By MAPWRAP = By.className("MapWrap");
    public By JOURNEYANY =  By.cssSelector("div.sortedResults > div:nth-child(2)");
    public By JOURNEYDETAIL =  By.className("JourneyDetail");
    public By JOURNEYDETAILBOOKING =  By.className("JourneyDetail-bookingBtn");
    public By BOOKINGPAGE =  By.className("Reservation-content");
    
    public By RESERVATIONDETAIL =  By.className("ReservationJourneyDetailWrapper");
    public By RESERVATIONPASSENGERS =  By.className("ReservationPassengers");
    public By RESERVATIONBILL =  By.className("ReservationBill");
    public By RESERVATIONPASSENGERADDBUTTON =  By.className("ReservationPassengers-addButton");
    public By RESERVATIONCONTACT =  By.className("ReservationContact");
    public By RESERVATIADVICES =  By.className("ReservationAdvices");
    public By RESERVATIONPAYMENT =  By.className("ReservationPayment");
    public By RESERVATIONPAYMENTBTNWRAPPER =  By.className("ReservationPayment-btnWrapper");
    public By PAYMENTALERT =  By.className("Alert");    
    public By RESERVATIONBILLPRICE =  By.className("ReservationBill-item-price");    

    
    public By OUTERDESC =  By.className("ouerDescription");
    public By PLACESLIST =  By.className("places-list");
    public By PLACEROW =  By.className("place-row");
    public By CALENDARGRID =  By.className("Calendar-grid");
    public By CALENDARDAY =  By.className("CalendarDay");
    public By CALENDARVIEW1 =  By.className("calendar-view-1");
    public By CALENDARVIEW2 =  By.className("calendar-view-2");



    
    
    
}
