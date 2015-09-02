package dailyMailPackage.pages;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;

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

@DefaultUrl("https://test.salesforce.com/")

public class DailyMailAccountPage extends PageObject {
	
	long timeNow = System.currentTimeMillis();
//	String url = "https://dmgsalescloud--prodmirror.cs7.my.salesforce.com/";
//	String url = "https://dmgsalescloud--systemtest.cs8.my.salesforce.com/";
	String url = "https://dmgsalescloud--prodmirror.cs80.my.salesforce.com/"; // prodmirror
		
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
	private WebElementFacade parentBookingSel() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:ParentBooking_Agency.input"));						}
	private WebElementFacade billingSelection() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Selection.input"));						} 
	private WebElementFacade billingOption() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options.input"));							} 
	private WebElementFacade billingOption1() 		{ return element(By.id("j_id0:j_id1:i:f:pb:d:Billing_Options_0.input"));						}
	private WebElementFacade selectBillingAgency() 	{ return element(By.id("j_id0:j_id1:i:f:pb:d:BillingAgencies.input"));							}
	private WebElementFacade selectBillingAgency1() { return element(By.id("j_id0:j_id1:i:f:pb:d:SelectBilling_Agency.input"));						}	
	private WebElementFacade contactSelection()     { return element(By.xpath("//*[@id='j_id0:j_id1:i:f:pb:d:Contact.input']")); 					}
	private WebElementFacade searchContact()     	{ 	return element(By.id("j_id0:j_id1:i:f:pb:d:Prompt_Contact_Name.input")); 					}
	private WebElementFacade finish() 				{ return element(By.id("j_id0:j_id1:i:f:pb:pbb:bottom:finish"));								}
	private WebElementFacade orderStatus()   		{ return element(By.id("Order.Identification:order.statusCode"));								}
	private WebElementFacade orderPurchaseNo()   	{ return element(By.id("Order.Identification:order.purchaseOrderNo"));							}
    private WebElementFacade orderNote()         	{ return element(By.id("Order.Identification:order.note"));					   					}
    private WebElementFacade orderUrgentNote()   	{ return element(By.id("Order.Identification:order.message"));									}
    private WebElementFacade orderSalesRepId()   	{ return element(By.id("Order.SalesTerritory:order.primarySalesRep.id"));						}
    private WebElementFacade orderSalesTerritory()  { return element(By.xpath("//*[@id='MaterialAccordion']/div/div[2]/div/div[2]/div/fieldset/div[2]/div/div/span/button/i"));	}
    private WebElementFacade orderSTInput()			{ return element(By.xpath("//*[@id='salesforce-plugin']/div[2]/div/div/form/div[2]/div/table/thead/tr[2]/th[1]/input")); 	}
    private WebElementFacade orderSTselect()			{ return element(By.xpath("//*[@id='salesforce-plugin']/div[2]/div/div/form/div[2]/div/table/tbody/tr/td[1]/span")); 	}
    private WebElementFacade addPackage()   	 	{ return element(By.xpath("//fieldset/div/div/div/h4/a/span"));									}
    private WebElementFacade title() 			 	{ return element(By.id("Order.Schedule:sched.titleCode"));										}
    private WebElementFacade selectPublication() 	{ return element(By.id("Order.Schedule:sched.publicationCode"));								}
    private WebElementFacade webSiteCategory()   	{ return element(By.id("Order.Schedule:sched.webSiteCategoryCode"));							}
    private WebElementFacade selectSection()     	{ return element(By.id("Order.Schedule:sched.sectionCode"));									}
    private WebElementFacade webSite()   		 	{ return element(By.id("Order.Schedule:sched.webSiteCode"));									}
    private WebElementFacade selectSubSection()  	{ return element(By.id("Order.Schedule:sched.subSectionCode"));									}
    private WebElementFacade selectZone()   	 	{ return element(By.id("Order.Schedule:"));														}
    private WebElementFacade distribution()   	 	{ return element(By.id("rder.Schedule:sched.distributionCode"));								}
    private WebElementFacade noOfInserts()   	 	{ return element(By.id("Order.Schedule:sched.noOfInserts"));									}
//    private WebElementFacade saveOrder()   	     	{ return element(By.xpath("//nav[button='Save']/button[2]"));								}
    private WebElementFacade selectModule()   	 	{ return element(By.id("Order.Material:material.moduleCode"));									}
    private WebElementFacade productionNote()   	{ return element(By.id("Order.Material:material.productionNote"));								}
    private WebElementFacade ABCopySplit()			{ return element(By.id(":propval.propertyBoolValue"));											}
    private WebElementFacade regionalCopySplit()   	{ return element(By.id("Order.Properties:Regional Copy Split"));								}
    private WebElementFacade color()   				{ return element(By.id("Order.Material:material.bookedCMYKColors"));					}
    private WebElementFacade selectPrice()   	 	{ return element(By.xpath(".//*[@id='SchedulingAccordion']/div/div[3]/div[1]/h4/a/span"));		}
    private WebElementFacade selectRevenue()   	 	{ return element(By.id("Order.Price:UserRevenue"));												}
    private WebElementFacade updateRevenue()   	 	{ return element(By.xpath("//fieldset/div/div[2]/div/div/span/button"));						}
    private WebElementFacade acceptOrder()   	 	{ return element(By.xpath("//nav[button='Accept']/button[3]"));									} 
    private WebElementFacade orderID()      	 	{ return element(By.xpath(".//*[@id='SchedulingAccordion']/div/div[1]/div[2]/div/div[2]/fieldset/div[1]/div/p")); }
    private WebElementFacade selectHeight()     	{ return element(By.xpath("//*[@id='Order.Material:material.bookedHeight']"));		}
    private WebElementFacade selectWidth()     		{ return element(By.xpath("//*[@id='Order.Material:material.bookedWidth']"));			}
   
    private WebElementFacade selectInsertion()   { return element(By.xpath("//*[@id='ActivePriceDetailView']/label[3]"));							}
    private WebElementFacade selectedInsertionDate(){ return element(By.xpath("//fieldset/div[2]/div/div/div[1]/div[2]/table/thead/tr/th[2]/a"));	}
    /******DM DISPLAY and TMOS *****/
    private WebElementFacade selectBasePrice()	 { return element(By.xpath("//tbody/tr[14]/td[1]/a"));												}
    private WebElementFacade supplyPriceType()	 { return element(By.xpath("//*[@id=':overridePriceDetail']"));										}
    private WebElementFacade supplyPrice()		 { return element(By.xpath("//tbody/tr[23]/td[3]/div/input"));										}
    private WebElementFacade updateInsLevelRevenue() { return element(By.xpath("//tbody/tr[23]/td[3]/div/span/button/i"));							}
    /******     MAILPLUS      *****/
    private WebElementFacade insertionDateMP()   { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/table/thead/tr/th[1]/a"));			}
    private WebElementFacade selectBasePriceMP() { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/div/table/tbody/tr[9]/td[1]/a"));	}
    private WebElementFacade supplyPriceMP()	 { return element(By.xpath("//fieldset/div[2]/div/div/div[2]/div/div/table/tbody/tr[18]/td[3]/div/input"));	}
    private WebElementFacade updateRevenueMP()   { return element(By.xpath("//tbody/tr[18]/td[3]/div/span/button/i"));							    }
    /******DAILY MAIL INSERTS*****/
    private WebElementFacade insertionDateDMI()  { return element(By.xpath("//fieldset/div[2]/div/div/div[3]/div/table/thead/tr/th[1]/a"));		    }
    private WebElementFacade selectBasePriceDMI(){ return element(By.xpath("//fieldset/div[2]/div/div/div[3]/div/div/table/tbody/tr[10]/td[1]/a"));	}
    private WebElementFacade supplyPriceDMI()	 { return element(By.xpath("//tbody/tr[19]/td[3]/div/input"));										}
    private WebElementFacade updateRevenueDMI()  { return element(By.xpath("//tbody/tr[19]/td[3]/div/span/button/i"));							    }
    /******Order level Price *****/
   
    public void supplyLogin_Credientials(String username, String password) {
    		waitFor(3).seconds();
    	getDriver().manage().window().maximize();
    	username().type(username);
    	password().type(password);
    }
    public void clickOnLogin(){
    	waitABit(1000);
    	loginbutton().click();
    	waitFor(20).seconds();
    }
    public void readfile(String fileloc) throws IOException{
    	
		File filePath = new File(fileloc);
		if (filePath.isFile()) {
			System.out.println("\n");
			System.out.println("         OREDRS THAT ARE SUCCESSFULLY CREATED ARE ");
			String file = filePath.getAbsolutePath();
			CSVTestDataSource testDataSrc = new CSVTestDataSource(file);
				for (Map<String, String> record : testDataSrc.getData()) 
				{
						try{
								waitFor(2).seconds();
							String str = record.get("accountType");
							rowNum = record.get("recordNo");
						
							String clinetuniqueID = record.get("uniqueID");
							String clientURL = url.concat(clinetuniqueID);
							/*System.out.println("client URL is -------- :  "+clientURL);*/
							getDriver().get(clientURL);
							waitFor(1).seconds();
							try {
						    	 WebDriverWait wait1 = new WebDriverWait(getDriver(), 3);
						    	 if(wait1.until(ExpectedConditions.alertIsPresent())!=null)
						    	      getDriver().switchTo().alert().accept();
						    	 }
						    	 catch (Exception x) {}
								waitFor(5).seconds();
							Thucydides.takeScreenshot();
							createDirectOrder().click();
								waitFor(4).seconds();
								if (str.equalsIgnoreCase("Brand"))
								{
										String selectionType = record.get("billingSelection");
										if (selectionType.equalsIgnoreCase("Parent"))
										{
											billingOption1().selectByVisibleText("Parent");
											clickNext().click();
											waitFor(1).second();
										}
										if (selectionType.equalsIgnoreCase("Agency"))
										{
											try{
											billingOption().selectByVisibleText(billingType);
											clickNext().click();
											}
											catch (Exception exp)
											{
												try{
													billingOption1().selectByVisibleText(billingType);
												}catch (Exception exp1){}
												
												clickNext().click();
											}
											waitFor(1).second();
											try {
													parentBookingSel().selectByVisibleText(record.get("bookingAgency"));
													waitFor(1).seconds();
												} catch (Exception e)
												{
													try {
													bookingSelection().selectByVisibleText(record.get("bookingAgency"));
													waitFor(1).seconds();
												}
													catch (Exception b1){}
												}
											clickNext().click();
											waitFor(2).second();
											try {
											selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
											clickNext().click();
										} catch (Exception b2){
											selectBillingAgency1().selectByVisibleText(record.get("billingAgency"));
											clickNext().click();}
										}
										if (selectionType.equalsIgnoreCase("Direct"))
										{
											billingSelection().selectByVisibleText(billingType);
											clickNext().click();
											waitFor(1).second();
										}
								}
								if (str.equalsIgnoreCase("Client") || str.equalsIgnoreCase("DMGT Group"))
								{
										String selectionType = record.get("agencyType");
										if (selectionType.equalsIgnoreCase("Booking Agency"))
										{
											try{
												selectAgencyType().selectByVisibleText(record.get("agencyType"));
												clickNext().click();
										}   catch (Exception exp){clickNext().click();}
												waitFor(3).seconds();
											bookingSelection().selectByVisibleText(record.get("bookingAgency"));
											clickNext().click();
												waitFor(3).seconds();
											selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
												waitFor(1).second();
											clickNext().click();
												waitFor(2).second();
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
															waitFor(2).second();
														bookingSelection().selectByVisibleText(record.get("bookingAgency"));
															waitFor(1).seconds();
														clickNext().click();
															waitFor(2).second();
														selectBillingAgency().selectByVisibleText(record.get("billingAgency"));
															waitFor(1).second();
														clickNext().click();
															waitFor(2).second();
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
								try
								{	
									searchContact().type(record.get("customerContact"));
									clickNext().click();
										waitFor(3).second();
									contactSelection().selectByVisibleText(record.get("customerContact"));
										waitFor(1).second();
								
								} catch (Exception notfound)
									{
									contactSelection().selectByVisibleText(record.get("customerContact"));
										waitFor(1).second();
									}
							clickNext().click();
								waitFor(1).seconds();
							finish().click();
		/************** Launch OrderPlugin and Create Order*************************************************/	
							 	 waitFor(8).seconds();
					     	 	 String sourceURL =getDriver().findElement(By.xpath("//*[@id='j_id0:j_id8']/div[2]/iframe")).getAttribute("src");
					     	 	 String[] firstsplit = sourceURL.split("authorizationcode=");
					     	 	 String[] secondpartsplit = firstsplit[1].split("\\&clientid=");
								 String acode = secondpartsplit[0];
								 String add = "&clientid=";
								 acode =record.get("authCode");
								 String date = record.get("addDate");
								 String packageType = record.get("package");
								 /*String sampleURL = "https://pre-prod.cci-webaccess-dmgmedia.co.uk/salesforce/plugin/orders/create?userid=srinivasa.kuncha&group=Mail Display Sales&profile=MD Manager&accountid=";*/ 
								 String redirectDM = "&bookings=[{\"packagename\":\"DM Display\",\"dates\":[\""+ date + "\"]}]";
								 String redirectTMOS = "&bookings=[{\"packagename\":\"TMOS Display\",\"dates\":[\""+ date + "\"]}]";
								 String redirectMDI = "&bookings=[{\"packagename\":\"Mail Display Inserts\",\"dates\":[\""+ date + "\"]}]";
								 String redirectMP = "&bookings=[{\"packagename\":\"MailPlus\",\"dates\":[\""+ date + "\"]}]";
								 
								 String Package = record.get("package");
								 
								 if(Package.equalsIgnoreCase("DM Display"))
								 {
									 String OrderURL=firstsplit[0].concat(acode).concat(add).concat(secondpartsplit[1]).concat(redirectDM);
									 getDriver().get(OrderURL);
								 }
								 if(Package.equalsIgnoreCase("TMOS Display"))
								 {
									 String OrderURL=firstsplit[0].concat(acode).concat(add).concat(secondpartsplit[1]).concat(redirectTMOS);
									 getDriver().get(OrderURL);
								 }
								 if(Package.equalsIgnoreCase("Mail Display Inserts"))
								 {
									 String OrderURL=firstsplit[0].concat(acode).concat(add).concat(secondpartsplit[1]).concat(redirectMDI);
									 getDriver().get(OrderURL);
								 }
								 if(Package.equalsIgnoreCase("MailPlus"))
								 {
									 String OrderURL=firstsplit[0].concat(acode).concat(add).concat(secondpartsplit[1]).concat(redirectMP);
									 getDriver().get(OrderURL);
								 }
								 waitFor(12).seconds();
		/************************************ Supply Order Details ******************************************/
					    	 orderPurchaseNo().sendKeys(record.get("PONumber"));
					    	 orderNote().sendKeys(record.get("orderNote"));
					    	 orderUrgentNote().sendKeys(record.get("urgentNote"));
					    	 orderStatus().selectByVisibleText(record.get("orderStatus"));
					    	 String salesrep = record.get("salesPerson");	
					    	 	if (!" ".equals(salesrep))
					    	 	{
					    	 		orderSalesRepId().selectByVisibleText(record.get("salesPerson"));
					    	 		waitFor(1).second();
					    	 	}
					    	 	orderSalesTerritory().click();
					    		waitFor(2).seconds();
					    		orderSTInput().type(record.get("salesTerritory"));
					    		waitFor(1).seconds();
					    		orderSTselect().click();
					    		waitFor(1).seconds();
					    	    order = orderID().getText();
					    	 	waitFor(1).second();
					    	 Thucydides.takeScreenshot();
		/************************************ Supply Package Details*****************************************/
					    	 		addPackage().click();  	
					    	 		waitFor(2).seconds();
					    	 		if (packageType.equalsIgnoreCase("MailPlus")) {
										 
										 webSiteCategory().selectByVisibleText(record.get("websitecategory"));
										 waitFor(2).seconds();
										 webSite().selectByVisibleText(record.get("website"));
										 waitFor(2).seconds();
										 selectSection().selectByVisibleText(record.get("section"));
								    	 waitFor(4).seconds();
										 selectZone().selectByVisibleText(record.get("adunit"));
										 waitFor(7).seconds();
									 }
									 if (packageType.equalsIgnoreCase("Mail Display Inserts")) {
										 
										 title().selectByVisibleText(record.get("title"));
										 selectPublication().selectByVisibleText(record.get("publication"));
								    	 waitFor(2).seconds();
								    	 distribution().selectByVisibleText(record.get("distribution"));
								    	 waitFor(6).seconds();
										 noOfInserts().type(record.get("numberOfInserts"));
										 waitFor(1).seconds();
									 }
									 if (packageType.equalsIgnoreCase("DM Display") || packageType.equalsIgnoreCase("TMOS Display")) 
									 {
//										 title().selectByVisibleText(record.get("title"));
										 selectPublication().selectByVisibleText(record.get("publication"));
								    	 waitFor(3).seconds();
								    	 selectSection().selectByVisibleText(record.get("section"));
								    	 waitFor(3).seconds();
								    	 selectSubSection().selectByVisibleText(record.get("subsection")); // subsection
								    	 waitFor(4).seconds();
								    	 selectZone().selectByVisibleText(record.get("zones"));
								    	 waitFor(5).seconds();
								    	 	String colour = record.get("colour");	 	
												 if (colour.equals("M"))
												 {
													 color().click();
													 waitFor(2).seconds();
												 }
										 	String salesmodule = record.get("module");
												if (!"".equals(salesmodule))
									    	 	{
														selectModule().selectByVisibleText(record.get("module"));
												    	waitFor(4).seconds();
									    	 	}
												else
												{
														selectHeight().sendKeys(record.get("height"));
														waitFor(2).seconds();
														selectWidth().clear();
														waitFor(2).seconds();
														selectWidth().typeAndEnter(record.get("width"));
														waitFor(2).seconds();
														productionNote().clear();
												}
								
											String zoneType = record.get("zones");
											/*rcs = rcs.replace('/', '\\'); System.out.println("the values that is supplied is : ----------------------------->"+rcs);*/
											
								/******************************************************************************************************/
								 /*		    rcs = record.get("regionalCopySplit");
								 		    		/
										 	    if (rcs.equalsIgnoreCase("England & Walescot")){
											 			rcs = "England & Wales\\Scot";
										 		}  
										 		if (rcs.equalsIgnoreCase("England & Walescot & N Ire")){
										 			rcs = "England & Wales\\Scot & N Ire";
										 		}
										 		if (rcs.equalsIgnoreCase("England & Walescot Ireire")){
										 			rcs = "England & Wales\\Scot\\N Ire\\Eire";
										 		}
										 		if (rcs.equalsIgnoreCase("Nat ex Lonon Only")){
										 			rcs = "Nat ex Lon\\Lon Only";
										 		}
										 		if (rcs.equalsIgnoreCase("Nat ex N Ire and Scot Ire Onlycot Only")){
										 			rcs = "Nat ex N Ire and Scot\\N Ire Only\\Scot Only";
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
										 		if (zoneType.equalsIgnoreCase("01. National") || zoneType.equalsIgnoreCase("02. North") || zoneType.equalsIgnoreCase("03. South"))
										 		{
											 		if (!" ".equals(rcs))
											 		{
											 			 waitFor(1).second();
											 			 regionalCopySplit().selectByVisibleText(rcs);
														 waitFor(2).seconds();
											 		}	
											 	}*/
										 		String ABcopySplitValue = record.get("copySplit");
										 		if (ABcopySplitValue.equalsIgnoreCase("Y"))
										 		{
										 			ABCopySplit().click();
										 			waitFor(2).second();
										 		}
										 		waitFor(1).seconds();
										 		productionNote().sendKeys(record.get("productionNote"));
												waitFor(1).seconds();
								    Thucydides.takeScreenshot();
								 }
						     			    	 
		/************************************ Supply Price Details ******************************************/
					    	
									 if (packageType.equalsIgnoreCase("DM Display") || packageType.equalsIgnoreCase("TMOS Display")) 
									 {
										 	/*selectPrice().click();
							    	 		waitFor(2).seconds();
							    	 		selectRevenue().sendKeys(record.get("revenue"));
							    	 		waitFor(2).seconds();
							    	 		updateRevenue().click(); 
							    	 		waitFor(5).seconds();
										 */
							    		 selectPrice().click(); 
							    		 waitFor(3).seconds();
							    		 selectInsertion().click();
							    		 waitFor(2).seconds();
							    		 selectedInsertionDate().click();
							    		 waitFor(2).seconds();
							    		 selectBasePrice().click();
							    		 waitFor(2).seconds();
							    		 supplyPriceType().selectByVisibleText("UserRevenue");
							    		 waitFor(1).seconds();
							    		 supplyPrice().type(record.get("revenue"));
							    		 waitFor(1).seconds();
							    		 updateInsLevelRevenue().click();
							    		 waitFor(4).seconds();
									 }
									 if (packageType.equalsIgnoreCase("MailPlus")) {
							    		 selectPrice().click();
							    		 waitFor(2).seconds();
							    		 selectInsertion().click();
							    		 waitFor(2).seconds();
							    		 insertionDateMP().click();
							    		 waitFor(3).seconds();
							    		 selectBasePriceMP().click();
							    		 waitFor(2).seconds();
							    		 supplyPriceType().selectByVisibleText("UserRevenue");
							    		 waitFor(1).seconds();
							    		 supplyPriceMP().type(record.get("revenue"));
							    		 waitFor(1).seconds();
							    		 updateRevenueMP().click();
							    		 waitFor(4).seconds();
							    	 Thucydides.takeScreenshot();	
							    	 }
									 if (packageType.equalsIgnoreCase("Mail Display Inserts")) {
						    			 
							    		 selectPrice().click();
							    		 waitFor(3).seconds();
							    		 selectInsertion().click();
							    		 waitFor(1).seconds();
							    		 insertionDateDMI().click();
						    			 waitFor(2).seconds();
						    			 selectBasePriceDMI().click();
							    		 waitFor(1).seconds();
							    		 supplyPriceType().selectByVisibleText("UserRevenue");
							    		 waitFor(1).seconds();
							    		 supplyPriceDMI().type(record.get("revenue"));
							    		 waitFor(2).seconds();
							    		 updateRevenueDMI().click();
							    		 waitFor(4).seconds();
							    	 Thucydides.takeScreenshot();
							    	 }
		/************************************ Accept Order *************************************************/	
					    	 System.out.println("       " +rowNum + " . " + " Order ID : " +order );	
					    	 acceptOrder().click();
					    	 	waitFor(2).seconds();
					    	 if(str.equalsIgnoreCase("Client") ||str.equalsIgnoreCase("Private Advertiser") || str.equalsIgnoreCase("Direct Advertiser")|| str.equalsIgnoreCase("Brand") || str.equalsIgnoreCase("Charity"))  {
					    		 	waitFor(1).seconds();
					    		 	try {
								    	 WebElement prepaymentwindow1 = getDriver().switchTo().activeElement();
								    	 		waitFor(1).second();
//								    	 prepaymentwindow1.findElement(By.xpath("//input[@value='Prepay']")).click();
								    	 prepaymentwindow1.findElement(By.xpath("//input[@value='Ignore']")).click();
								    	 		waitFor(3).seconds();
								    	 prepaymentwindow1.findElement(By.xpath("//input[@value='Ignore']")).click();
								    	 waitFor(1).second(); 
								    	 /*WebElement prepaymentwindow2 = getDriver().switchTo().activeElement();
								    	 		waitFor(1).second(); 
								    	 prepaymentwindow2.findElement(By.xpath("//input[@value='OK']")).click();*/
					    		 	} catch (Exception e) {}
					    	 }
					    	 waitFor(5).seconds();
	  /*************************************************************************************************/
					} catch (Exception e)
						{
						System.out.println("       " +rowNum + " ---> " + "Sorry! either DATA/Latency issue please check test report for details" );
						Thucydides.takeScreenshot();
						try {
					    	 WebDriverWait wait1 = new WebDriverWait(getDriver(), 3);
					    	 if(wait1.until(ExpectedConditions.alertIsPresent())!=null)
					    	      getDriver().switchTo().alert().accept();
					    	 }
					    	 catch (Exception x) {}
									
						}
						
				} 
	}		
}
}