package com.sampleTest;

import org.junit.Test;

import com.sampleTest.config.ConfigTest;
import com.sampleTest.pages.MainPage;


public class MainPageTest extends ConfigTest {
	   public MainPageTest(String os, String version, String browser, String deviceName, String deviceOrientation) {
		super(os, version, browser, deviceName, deviceOrientation);
		// TODO Auto-generated constructor stub
	}

	/**
	    * Test Case 1
		* Open the "https://www.kiwi.com/tr/";
		* Check mainpage elements(Search Form, Serach Form Mode, Passenger Fields, One Way Section)
		* Check Place Of Origin Field and Enter Origin, Check Place Of Destination Field and Enter Destination
		* Check Result Journey , Map And Progress Bar
		* Click any result journey and check detail of journey, check booking button and click it
		* Check Booking page, Reservation detail, Passenger and Bill Information
		* Check Passenger Add Button And Click  Button and Check Changes Reservation Bill Price
		* Check Reservation Contact Field, Visa Requirements Advices And Reservation Payment Field
		* And Click Reservation Payment Button With missing information And Check Alert Messages
	    */
		@Test
		public void checkKiwiReservationAndBookingPage(){
			MainPage mp =new MainPage(driver);
			//check Search Form Elements
			mp.isMainPage().isSearchForm().isSearchFormModeAndPassengerFields();
			mp.clickOneWay().isSearchFormOneWay();
			
			//enter origin and destination places
			String placeOfOrigin = "Istanbul", placeOfDestination="Prag";
			mp.deleteDefaultPlaceOfOrigin()
			.enterPlaceOfOrigin(placeOfOrigin);
			mp.deleteDefaultPlaceOfDestination()
			.enterPlaceOfDestination(placeOfDestination); 
			
			//check map and result journey
			mp.isResultsField().isLoadingBarAndMapWrap()
			.clickAnyResultJourney()
			.checkJourneyDetailField()
			.checkJourneyDetailBookingButtonAndClickIt();
			
			//check booking page
            mp.checkBookingPage()
			.checkReservationDetailPassengerAndBill()
			.checkPassengerAddBtnAndClickBtnThanCheckPriceChanges()
			.checkReservationContactField()
			.checkReservationVisaRequirementsAdvices()
			.checkReservationPaymentField();
            
            //payment with missing information
            mp.checkReservationPaymentBtn()
            .checkPaymentAlert();
		}
		
}
