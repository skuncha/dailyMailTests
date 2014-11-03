package dailyMailPackage.pages;

import java.io.File;
import java.util.Map;

import net.thucydides.core.Thucydides;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.csv.CSVTestDataSource;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author srinivasa.kuncha
 *
 */
@DefaultUrl("http://test.salesforce.com")
public class GlueAccountPage extends PageObject {
	
	long timeNow = System.currentTimeMillis();
	String url = "https://dmgsalescloud--prodmirror.cs8.my.salesforce.com/";
	String order,rowNum;
	String billingType = "Agency";
	static String rcs;
    @FindBy(xpath="//div/input")
    private WebElementFacade searchTerms;

    @FindBy(id="phSearchButton")
    private WebElementFacade lookupButton;

    private WebElementFacade username() 			{ return element(By.id("username"));															}
	private WebElementFacade password() 			{ return element(By.id("password"));															}
	private WebElementFacade loginbutton() 			{ return element(By.id("Login"));																}
	private WebElementFacade billingRef()        	{ return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Billing_AgenciesList.input']"));  		}
	private WebElementFacade clickNext() 			{ return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:next"));									}
	private WebElementFacade createDirectOrder() 	{ return element(By.cssSelector("input[value='Create Direct Order']"));							}
	private WebElementFacade selectAgencyType()     { return element(By.id("j_id0:j_id1:i:f:pb:d:Agency_Type.input"));								}
	private WebElementFacade bookingSelection() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:Booking_AgenciesList.input"));						}
	private WebElementFacade billingSelection() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Selection.input"));						}
	private WebElementFacade billingOption() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options.input"));							}
	private WebElementFacade selectBillingAgency() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:BillingAgencies.input"));							}
	private WebElementFacade contactSelection()     { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Contact.input']")); 					}
	private WebElementFacade finish() 				{ return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:finish"));								}
	private WebElementFacade orderPurchaseNo()   	{ return element(By.id("Order.Identification:order.purchaseOrderNo"));							}
    private WebElementFacade orderNote()         	{ return element(By.id("Order.Identification:order.note"));					   					}
    private WebElementFacade orderUrgentNote()   	{ return element(By.id("Order.Identification:order.message"));									}
    private WebElementFacade orderSalesRepId()   	{ return element(By.id("Order.SalesTerritory:order.primarySalesRep.id"));						}
    private WebElementFacade addPackage()   	 	{ return element(By.xpath("//h4/a/span/input"));												}
    private WebElementFacade title() 			 	{ return element(By.id("Order.Schedule:sched.titleCode"));										}
    private WebElementFacade selectPublication() 	{ return element(By.id("Order.Schedule:sched.publicationCode"));								}
    private WebElementFacade webSiteCategory()   	{ return element(By.id("Order.Schedule:sched.webSiteCategoryCode"));							}
    private WebElementFacade selectSection()     	{ return element(By.id("Order.Schedule:sched.sectionCode"));									}
    private WebElementFacade webSite()   		 	{ return element(By.id("Order.Schedule:sched.webSiteCode"));									}
    private WebElementFacade selectSubSection()  	{ return element(By.id("Order.Schedule:sched.subSectionCode"));									}
    private WebElementFacade selectZone()   	 	{ return element(By.id("Order.Schedule:"));														}
    private WebElementFacade distribution()   	 	{ return element(By.id("rder.Schedule:sched.distributionCode"));								}
    private WebElementFacade noOfInserts()   	 	{ return element(By.id("Order.Schedule:sched.noOfInserts"));									}
    private WebElementFacade saveOrder()   	     	{ return element(By.xpath("//nav[button='Save']/button[2]"));									}
    private WebElementFacade selectModule()   	 	{ return element(By.id("Order.Schedule.Material:material.moduleCode"));							}
    private WebElementFacade productionNote()   	{ return element(By.id("Order.Schedule.Material:material.productionNote"));						}
    private WebElementFacade ABCopySplit()			{ return element(By.id(":propval.propertyBoolValue"));											}
    private WebElementFacade regionalCopySplit()   	{ return element(By.id("Order.Properties:Regional Copy Split"));								}
    private WebElementFacade spreadAd()   			{ return element(By.id("Order.Schedule.Material:material.isSpreadAd"));							}
    private WebElementFacade color()   				{ return element(By.id("Order.Schedule.Material:material.bookedCMYKColors "));					}
    private WebElementFacade pageRequest()   		{ return element(By.id("Order.Schedule:schedule.pageRequest"));									}
    private WebElementFacade nextMonth()   	 	 	{ return element(By.xpath("//thead/tr[1]/th/span[4]/span[3]/i"));								}
    private WebElementFacade selectPrice()   	 	{ return element(By.xpath(".//*[@id='SchedulingAccordion']/div/div[3]/div[1]/h4/a/span"));		}
    private WebElementFacade selectRevenue()   	 	{ return element(By.id("Order.Price:UserRevenue"));												}
    private WebElementFacade updateRevenue()   	 	{ return element(By.xpath("//fieldset/div/div[2]/div/div/span/button"));						}
    private WebElementFacade acceptOrder()   	 	{ return element(By.xpath("//nav[button='Accept']/button[3]"));									} 
    private WebElementFacade orderID()      	 	{ return element(By.xpath(".//*[@id='SchedulingAccordion']/div/div[1]/div[2]/div/div[2]/fieldset/div[1]/div/p")); }
    

    public void supplyLogin_Credientials(String username, String password) {
    	getDriver().manage().window().maximize();
    	username().type(username);
    	password().type(password);
    }
    public void clickOnLogin(){
    	waitABit(1000);
    	loginbutton().click();
    }
    public void readfile(String fileloc){
    	
		File filePath = new File(fileloc);
		if (filePath.isFile()) {
			System.out.println("\n      OREDRS THAT ARE SUCCESSFULLY CREATED ARE ");
			String file = filePath.getAbsolutePath();
			try {
				CSVTestDataSource testDataSrc = new CSVTestDataSource(file);
				for (Map<String, String> record : testDataSrc.getData()) {
					waitFor(5).seconds();
					String str = record.get("accountType");
					String clinetuniqueID = record.get("uniqueID");
					String clientURL = url.concat(clinetuniqueID);
					/*System.out.println("client URL is -------- :  "+clientURL);*/
					getDriver().get(clientURL);
					waitFor(12).seconds();
					createDirectOrder().click();
					waitFor(4).seconds();
					
						if (str.equalsIgnoreCase("Brand"))
						{
								String selectionType = record.get("billingSelection");
								if (selectionType.equalsIgnoreCase("Via Agency"))
								{
									billingOption().selectByVisibleText(billingType);
										waitFor(1).second();
									clickNext().click();
									bookingSelection().selectByVisibleText(record.get("bookingAgency"));
										waitFor(1).seconds();
									clickNext().click();
									waitFor(2).second();
									selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
										waitFor(2).second();
									clickNext().click();
								}
								else
								{
									billingOption().selectByVisibleText("Direct");
										waitFor(1).second();
									clickNext().click();
								}
						}
						if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group"))
						{
								String selectionType = record.get("agencyType");
								if (selectionType.equalsIgnoreCase("Booking Agency"))
								{
									try{
									selectAgencyType().selectByVisibleText(selectionType);
										waitFor(1).second();
									}catch (Exception e){}	
									clickNext().click();
										waitFor(2).seconds();
									bookingSelection().selectByVisibleText(record.get("bookingAgency"));
									clickNext().click();
										waitFor(2).seconds();
									selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
										waitFor(1).second();
										
									clickNext().click();
								}
								else 
								{ 
									billingRef().selectByVisibleText(record.get("billingAgency"));
										waitFor(1).second();
									clickNext().click();
								}
						}
						if (str.equalsIgnoreCase("Direct Advertiser")|| str.equalsIgnoreCase("Charity")) 
						 {
									String billingType = record.get("billingSelection");
									if (billingType.equalsIgnoreCase("Direct"))
									{
										billingSelection().selectByVisibleText(billingType);
											waitFor(1).second();
										clickNext().click();
									}
									else 
									{
										billingSelection().selectByVisibleText(billingType);
											waitFor(1).second();
										clickNext().click();
											String selectionType = record.get("agencyType");
											if (selectionType.equalsIgnoreCase("Booking Agency"))
											{
												billingOption().selectByVisibleText(billingType);
												waitFor(1).second();
												clickNext().click();
												bookingSelection().selectByVisibleText(record.get("bookingAgency"));
													waitFor(1).seconds();
												clickNext().click();
												selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
												waitFor(1).second();
												clickNext().click();
											}
											else 
											{ 
												billingRef().selectByVisibleText(record.get("billingAgency"));
													waitFor(1).second();
												clickNext().click();
											}
									}
						 }
						waitFor(2).seconds();
					contactSelection().selectByVisibleText(record.get("customerContact"));
						waitFor(1).seconds();
					clickNext().click();
						waitFor(1).seconds();
					finish().click();
					
/************** Launch OrderPlugin and Create Order*************************************************/	
					
					 	 waitFor(11).seconds();
			     	 	 String sourceURL =getDriver().findElement(By.xpath("//*[@id='j_id0:j_id8']/div[2]/iframe")).getAttribute("src");
			     	 	 String[] firstsplit = sourceURL.split("authorizationcode=");
			     	 	 String[] secondpartsplit = firstsplit[1].split("\\&clientid=");
						 String acode = secondpartsplit[0];
						 String add = "&clientid=";
						 acode =record.get("authCode");
						 String date = record.get("addDate");
						 /*String sampleURL = "https://pre-prod.cci-webaccess-dmgmedia.co.uk/salesforce/plugin/orders/create?userid=srinivasa.kuncha&group=Mail Display Sales&profile=MD Manager&accountid=";*/ 
						 String redirect = "&bookings=[{\"packagename\":\"DM Display\",\"dates\":[\""+ date + "\"]}]";
						 String OrderURL=firstsplit[0].concat(acode).concat(add).concat(secondpartsplit[1]).concat(redirect);
						 getDriver().get(OrderURL);
						 waitFor(9).seconds();
						  
/************************************ Supply Order Details ******************************************/
			    	 orderPurchaseNo().sendKeys(record.get("PONumber"));
			    	 orderNote().sendKeys(record.get("orderNote"));
			    	 orderUrgentNote().sendKeys(record.get("urgentNote"));
			    	 order = orderID().getText();
			    	 waitFor(1).second();
			    	 Thucydides.takeScreenshot();
/************************************ Supply Package Details*****************************************/
			    	 addPackage().click();  	
			    	 		waitFor(4).seconds();
			    	 addPackage().click(); 
			    	 		waitFor(3).seconds();
				     selectPublication().selectByVisibleText(record.get("publication"));
				    	 	waitFor(3).seconds();
				     selectSection().selectByVisibleText(record.get("section"));
				    	 	waitFor(5).seconds();
				     selectZone().selectByVisibleText(record.get("zones"));
				    	 	waitFor(6).seconds();
				     selectSubSection().selectByVisibleText(record.get("subsection"));
				    		waitFor(6).seconds();
				     productionNote().sendKeys(record.get("productionNote"));
						 	waitFor(2).seconds();
				     selectModule().selectByVisibleText(record.get("module"));
					    	waitFor(5).seconds();
					 String zoneType = record.get("zones");
					 		
					 		 rcs = record.get("regionalCopySplit");
					 		if (rcs.equalsIgnoreCase("England & Walescot & N Ire")){
					 			rcs = "England & Wales\\Scot & N Ire";
					 		}
					 		if (rcs.equalsIgnoreCase("England & Walescot Ireire")){
					 			rcs = "England & Wales\\Scot\\N Ire\\Eire";
					 		}
					 		if (rcs.equalsIgnoreCase("Nat ex Lonon Only")){
					 			rcs = "Nat ex Lon\\Lon Only";
					 		}
					 		if (rcs.equalsIgnoreCase("Nat ex N Ire and Scot Ire Onlycot")){
					 			rcs = "Nat ex N Ire and Scot\\N Ire Only\\Scot";
					 		}
					 		if (rcs.equalsIgnoreCase("Nat ex N Ire Ire Only")){
					 			rcs = "Nat ex N Ire\\N Ire Only";
					 		}
					 		if (rcs.equalsIgnoreCase("Nat ex Scotcot Only")){
					 			rcs = "Nat ex Scot\\Scot Only";
					 		}
					 		if (rcs.equalsIgnoreCase("Nthth")){
					 			rcs = "Nth\\Sth";
					 		}
					 		if (rcs.equalsIgnoreCase("Nththcot")){
					 			rcs = "Nth\\Sth\\Scot";
					 		}
					 		if (rcs.equalsIgnoreCase("Nth ex Scotcot Only")){
					 			rcs = "Nth ex Scot\\Scot Only";
					 		}
					 		if (rcs.equalsIgnoreCase("Sth ex Lonon Only")){
					 			rcs = "Sth ex Lon\\Lon Only";
					 		}
					 		/*System.out.println("     regional Copy Split supplied is :  "+rcs);*/
					 		if (zoneType.equalsIgnoreCase("01. National") || zoneType.equalsIgnoreCase("02. North") || zoneType.equalsIgnoreCase("03. South"))
					 		{
						 		if (!" ".equals(rcs))
						 		{
						 			 waitFor(1).second();
						 			 regionalCopySplit().selectByVisibleText(rcs);
									 waitFor(2).seconds();
						 		}	
						 	}
					 		String ABcopySplitValue = record.get("copySplit");
					 		if (ABcopySplitValue.equalsIgnoreCase("Y"))
					 		{
					 			
					 			ABCopySplit().click();
					 			waitFor(2).second();
					 		}
			    	 Thucydides.takeScreenshot();
			    	 /*saveOrder().click();
			    	 		waitFor(10).seconds();*/
			    	 
/************************************ Supply Price Details ******************************************/
			    	 selectPrice().click();
			    	 		waitFor(1).second();
			    	 selectRevenue().sendKeys(record.get("revenue"));
			    	 		waitFor(1).second();
			    	 updateRevenue().click(); 
			    	 		waitFor(2).seconds();
			    	 Thucydides.takeScreenshot();	
/************************************ Accept Order *************************************************/	
			    	 acceptOrder().click();
			    	 if(str.equalsIgnoreCase("Private Advertiser") || str.equalsIgnoreCase("Direct Advertiser")|| str.equalsIgnoreCase("Brand") || str.equalsIgnoreCase("Charity"))  {
			    		 	waitFor(1).seconds();
			    		 	try {
						    	 WebElement prepaymentwindow1 = getDriver().switchTo().activeElement();
						    	 		waitFor(1).second();
						    	 prepaymentwindow1.findElement(By.xpath("//input[@value='Prepay']")).click();
						    	 		waitFor(3).seconds();
						    	 WebElement prepaymentwindow2 = getDriver().switchTo().activeElement();
						    	 		waitFor(1).second(); 
						    	 prepaymentwindow2.findElement(By.xpath("//input[@value='OK']")).click();
			    		 	} catch (Exception e) {}
			    	 }
			    	 rowNum = record.get("recordNo");
			    	 System.out.println("       " +rowNum + " . " + " Order ID : " +order );	
			    	 waitFor(8).seconds();
			    	 try {
				    	 WebDriverWait wait1 = new WebDriverWait(getDriver(), 3);
				    	 if(wait1.until(ExpectedConditions.alertIsPresent())!=null)
				    	      getDriver().switchTo().alert().accept();
				    	 }
				    	 catch (Exception e) {}
/*************************************************************************************************/
				} 
		} catch (Exception e){e.printStackTrace();}
	}		
}
}