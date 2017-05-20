package com.sampleTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.ClickAndHoldAction;

import static org.junit.Assert.*;

import com.sampleTest.Ids.MainPageIds;

public class MainPage extends MainPageIds {

	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MainPage isMainPage() {
		assertTrue("Homepage couldn't be uploaded.", isElementPresent(LOGOKIWI));
		return this;
	}

	public MainPage isSearchForm() {
		assertTrue("SearchForm couldn't be uploaded", isElementPresent(SEARCHFORM));
		return this;
	}
	public MainPage isSearchFormModeAndPassengerFields() {
		assertTrue("SearchForm mode and passenger fields Options couldn't be appear", isElementPresent(SEARCHFORMMODES) & isElementPresent(SEARCHPASSENGERFIELD));
		return this;
	}
	public MainPage clickOneWay() {
		clickObjectBy(ONEWAY);
		return this;
	}
	public MainPage isSearchFormOneWay() {
		assertTrue("SearchFormOneWay Field couldn't be appear", isElementPresent(SEARCHFORMONEWAY));
		return this;
	}
 
	public MainPage deleteDefaultPlaceOfOrigin() {
		clickObjectBy(INPUTPLACESORIGIN);
		getElementBy(INPUTPLACESORIGIN).sendKeys(Keys.DELETE);
		getElementBy(INPUTPLACESORIGIN).sendKeys(Keys.DELETE);
		sleep(5000);
		return this;
	}
	public MainPage enterPlaceOfOrigin(String place) {
		setObjectBy(INPUTPLACESORIGIN, place);
		getElementBy(INPUTPLACESORIGIN).sendKeys(Keys.ENTER);sleep(3000);
		return this;
	}
	
	public MainPage deleteDefaultPlaceOfDestination() {
		clickObjectBy(INPUTPLACESDESTINATION);
		getElementBy(INPUTPLACESDESTINATION).sendKeys(Keys.DELETE);
		getElementBy(INPUTPLACESDESTINATION).sendKeys(Keys.DELETE);
		sleep(5000);
		return this;
	}
	public MainPage enterPlaceOfDestination(String place) {
		setObjectBy(INPUTPLACESDESTINATION, place);
		getElementBy(INPUTPLACESDESTINATION).sendKeys(Keys.ENTER);sleep(3000);
		return this;
	}
	
	public MainPage isResultsField() {
		assertTrue("Results fields couldn't be appear", isElementPresent(RESULTS));
		return this;
	}
	
	public MainPage isLoadingBarAndMapWrap() {
		assertTrue("Loading Bar couldn't be appear", isElementPresent(LOADINGBAR));
		assertTrue("MapWrap couldn't be appear", isElementPresent(MAPWRAP));
		return this;
	}
	
	public MainPage clickAnyResultJourney() {
		clickObjectBy(JOURNEYANY);
		return this;
	}
	
	public MainPage checkJourneyDetailField() {
		assertTrue("Journey detail couldn't be appear", isElementPresent(JOURNEYDETAIL));
		return this;
	}
	
	public MainPage checkJourneyDetailBookingButtonAndClickIt() {
		assertTrue("Journey detail booking couldn't be appear", isElementPresent(JOURNEYDETAILBOOKING));
	    clickObjectBy(JOURNEYDETAILBOOKING);
		return this;
	}
	
	public MainPage checkBookingPage() {
		assertTrue("Bookingpage couldn't be uploaded.", isElementPresent(BOOKINGPAGE));
		return this;
	}
	
	public MainPage checkReservationDetailPassengerAndBill() {
		assertTrue("Reservaton detail field couldn't be appear.", isElementPresent(RESERVATIONDETAIL));
		assertTrue("Reservation passenger field couldn't be appear.", isElementPresent(RESERVATIONPASSENGERS));
		assertTrue(" ReservationBill field couldn't be appear.", isElementPresent(RESERVATIONBILL));
		return this;
	}
	
	public MainPage checkPassengerAddBtnAndClickBtnThanCheckPriceChanges() {
		assertTrue("Reservation passenger add button couldn't be appear.", isElementPresent(RESERVATIONPASSENGERADDBUTTON));
		String reservationBillPriceBefore = getElementBy(RESERVATIONBILLPRICE).getText();
		System.out.println("ReservationBillPriceOnePassenger :" + reservationBillPriceBefore);
		clickObjectBy(RESERVATIONPASSENGERADDBUTTON);
		String reservationBillPriceAfter = getElementBy(RESERVATIONBILLPRICE).getText();
		System.out.println("ReservationBillPriceTwoPassenger" +reservationBillPriceAfter);
		assertNotEquals("Passenger couldn't be added and pricing has not changed",
				reservationBillPriceBefore,
				reservationBillPriceAfter);
		return this;
	}
	
	
	public MainPage checkReservationContactField() {
		assertTrue("Reservation contact field couldn't be appear.", isElementPresent(RESERVATIONCONTACT));
		return this;
	}
	
	public MainPage checkReservationVisaRequirementsAdvices() {
		assertTrue("Reservation visa re field couldn't be appear.", isElementPresent(RESERVATIADVICES));
		return this;
	}
	
	public MainPage checkReservationPaymentField() {
		assertTrue("Reservation payment field couldn't be appear.", isElementPresent(RESERVATIONPAYMENT));
		return this;
	}
	
	public MainPage checkReservationPaymentBtn() {
		assertTrue("Reservation payment button couldn't be appear.", isElementPresent(RESERVATIONPAYMENTBTNWRAPPER));
		clickObjectBy(RESERVATIONPAYMENTBTNWRAPPER);
		return this;
	}
	
	public MainPage checkPaymentAlert() {
		assertTrue("Payment alert messages couldn't be appear.", isElementPresent(PAYMENTALERT));
		return this;
	}

}
