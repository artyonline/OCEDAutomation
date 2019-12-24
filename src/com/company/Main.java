package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");

        String[] countryArray = {" Spain", " Sweden", " Switzerland", " Turkey", " United Kingdom", " United States", " Brazil", " China (People’s Republic of)", " India", " Indonesia", " Russia", " South Africa", " Algeria", " Angola", " Benin", " Botswana", " Burkina Faso", " Burundi", " Cameroon", " Cabo Verde", " Central African Republic", " Comoros", " Congo (Brazzaville)", " Democratic Republic of the Congo (Kinshasa)", " Chad (Republic of)", " Côte d'Ivoire", " Djibouti", " Egypt", " Lesotho", " Eritrea", " Ethiopia", " Gabon", " Gambia", " Ghana", " Guinea", " Guinea-Bissau", " Equatorial Guinea (Republic of)", " Kenya", " Liberia", " Libya", " Madagascar", " Malawi", " Mali", " Mauritania", " Mauritius", " Morocco", " Mozambique", " Namibia", " Niger", " Nigeria", " Rwanda", " Sao Tome & Principe", " Senegal", " Seychelles", " Sierra Leone", " Sudan", " South Sudan", " Eswatini", " Tanzania", " Togo", " Tunisia", " Uganda", " Zambia", " Zimbabwe", " Argentina", " Antigua and Barbuda", " Aruba", " Bahamas", " Barbados", " Belize", " Bermuda", " Bolivia", " Colombia", " Costa Rica", " Cuba", " Dominica", " Dominican Republic", " Ecuador", " El Salvador", " Haïti (Republic of)", " Grenada", " Guatemala", " Guyana", " Honduras", " Jamaica", " Montserrat", " Nicaragua", " Panama", " Paraguay", " Peru", " Saint Lucia", " Saint Kitts and Nevis", " Saint Vincent and the Grenadines", " Suriname", " Trinidad and Tobago", " Uruguay", " Venezuela", " Afghanistan", " Armenia", " Azerbaijan", " Bahrain", " Bangladesh", " Brunei Darussalam", " Bhutan", " Cambodia", " Cyprus", " Georgia", " Hong Kong, China", " Iraq", " Iran", " Jordan", " Kazakhstan", " Korea, Democratic People's Republic", " Kuwait", " Kyrgyzstan", " Lao, People’s Democratic Republic", " Lebanon", " Macau, China", " Malaysia", " Maldives", " Mongolia", " Myanmar", " Nepal", " Oman", " Pakistan", " Palestinian Authority or West Bank and Gaza Strip", " Philippines", " Qatar", " Saudi Arabia", " Singapore", " Sri Lanka", " Syrian Arab Republic", " Tajikistan", " Timor-Leste", " Turkmenistan", " Chinese Taipei", " Thailand", " United Arab Emirates", " Uzbekistan", " Viet Nam", " Yemen", " Albania", " Andorra", " Belarus", " Bosnia and Herzegovina", " Bulgaria", " Croatia", " Greenland", " Malta", " Moldova", " Montenegro", " North Macedonia", " Romania", " Serbia", " Ukraine", " Fiji", " Kiribati", " Marshall Islands", " Micronesia (Federated States of)", " Nauru (Republic of)", " New Caledonia", " Palau (Republic of)", " Papua New Guinea", " Samoa", " Solomon Islands", " Tonga", " Tuvalu", " Vanuatu", " Rest of World", " Unspecified", " Total foreign trade"};

        String[] countryWithCode = { "ESP: Spain", "SWE: Sweden", "CHE: Switzerland", "TUR: Turkey", "GBR: United Kingdom", "USA: United States", "BRA: Brazil", "CHN: China (People’s Republic of)", "IND: India", "IDN: Indonesia", "RUS: Russia", "ZAF: South Africa", "DZA: Algeria", "AGO: Angola", "BEN: Benin", "BWA: Botswana", "BFA: Burkina Faso", "BDI: Burundi", "CMR: Cameroon", "CPV: Cabo Verde", "CAF: Central African Republic", "COM: Comoros", "COG: Congo (Brazzaville)", "COD: Democratic Republic of the Congo (Kinshasa)", "TCD: Chad (Republic of)", "CIV: Côte d'Ivoire", "DJI: Djibouti", "EGY: Egypt", "LSO: Lesotho", "ERI: Eritrea", "ETH: Ethiopia", "GAB: Gabon", "GMB: Gambia", "GHA: Ghana", "GIN: Guinea", "GNB: Guinea-Bissau", "GNQ: Equatorial Guinea (Republic of)", "KEN: Kenya", "LBR: Liberia", "LBY: Libya", "MDG: Madagascar", "MWI: Malawi", "MLI: Mali", "MRT: Mauritania", "MUS: Mauritius", "MAR: Morocco", "MOZ: Mozambique", "NAM: Namibia", "NER: Niger", "NGA: Nigeria", "RWA: Rwanda", "STP: Sao Tome & Principe", "SEN: Senegal", "SYC: Seychelles", "SLE: Sierra Leone", "SDN: Sudan", "SSD: South Sudan", "SWZ: Eswatini", "TZA: Tanzania", "TGO: Togo", "TUN: Tunisia", "UGA: Uganda", "ZMB: Zambia", "ZWE: Zimbabwe", "ARG: Argentina", "ATG: Antigua and Barbuda", "ABW: Aruba", "BHS: Bahamas", "BRB: Barbados", "BLZ: Belize", "BMU: Bermuda", "BOL: Bolivia", "COL: Colombia", "CRI: Costa Rica", "CUB: Cuba", "DMA: Dominica", "DOM: Dominican Republic", "ECU: Ecuador", "SLV: El Salvador", "HTI: Haïti (Republic of)", "GRD: Grenada", "GTM: Guatemala", "GUY: Guyana", "HND: Honduras", "JAM: Jamaica", "MSR: Montserrat", "NIC: Nicaragua", "PAN: Panama", "PRY: Paraguay", "PER: Peru", "LCA: Saint Lucia", "KNA: Saint Kitts and Nevis", "VCT: Saint Vincent and the Grenadines", "SUR: Suriname", "TTO: Trinidad and Tobago", "URY: Uruguay", "VEN: Venezuela", "AFG: Afghanistan", "ARM: Armenia", "AZE: Azerbaijan", "BHR: Bahrain", "BGD: Bangladesh", "BRN: Brunei Darussalam", "BTN: Bhutan", "KHM: Cambodia", "CYP: Cyprus", "GEO: Georgia", "HKG: Hong Kong, China", "IRQ: Iraq", "IRN: Iran", "JOR: Jordan", "KAZ: Kazakhstan", "PRK: Korea, Democratic People's Republic", "KWT: Kuwait", "KGZ: Kyrgyzstan", "LAO: Lao, People’s Democratic Republic", "LBN: Lebanon", "MAC: Macau, China", "MYS: Malaysia", "MDV: Maldives", "MNG: Mongolia", "MMR: Myanmar", "NPL: Nepal", "OMN: Oman", "PAK: Pakistan", "PSE: Palestinian Authority or West Bank and Gaza Strip", "PHL: Philippines", "QAT: Qatar", "SAU: Saudi Arabia", "SGP: Singapore", "LKA: Sri Lanka", "SYR: Syrian Arab Republic", "TJK: Tajikistan", "TLS: Timor-Leste", "TKM: Turkmenistan", "TWN: Chinese Taipei", "THA: Thailand", "ARE: United Arab Emirates", "UZB: Uzbekistan", "VNM: Viet Nam", "YEM: Yemen", "ALB: Albania", "AND: Andorra", "BLR: Belarus", "BIH: Bosnia and Herzegovina", "BGR: Bulgaria", "HRV: Croatia", "GRL: Greenland", "MLT: Malta", "MDA: Moldova", "MNE: Montenegro", "MKD: North Macedonia", "ROU: Romania", "SRB: Serbia", "UKR: Ukraine", "FJI: Fiji", "KIR: Kiribati", "MHL: Marshall Islands", "FSM: Micronesia (Federated States of)", "NRU: Nauru (Republic of)", "NCL: New Caledonia", "PLW: Palau (Republic of)", "PNG: Papua New Guinea", "WSM: Samoa", "SLB: Solomon Islands", "TON: Tonga", "TUV: Tuvalu", "VUT: Vanuatu", "ROW: Rest of World", "SEC: Unspecified", "TTX: Total foreign trade"};


        for (int a = 0; a< countryArray.length; a++)
        {
            System.out.println(countryArray[a]);

            String downloadFilepath = "D:\\DataCollectionDownload1\\"+countryArray[a]+"1";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            WebDriver driver = new ChromeDriver(cap);


//        WebDriver driver = new ChromeDriver();
            Actions actions = new Actions(driver);

            //To wait for element visible

            WebDriverWait wait = new WebDriverWait(driver, 30);

            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            try{
                driver.get("https://stats.oecd.org/Index.aspx?DataSetCode=BTDIXE_I4#");
            }catch(WebDriverException e){
                driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_COU")));
                Select countryDrpDwn = new Select(driver.findElement(By.id("PDim_COU")));
                countryDrpDwn.selectByValue("35~GBR");
                TimeUnit.SECONDS.sleep(25);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                Select element = new Select(driver.findElement(By.id("PDim_IND")));
                List<WebElement> opts = element.getOptions();
                TimeUnit.SECONDS.sleep(5);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_PAR")));
                Select partnerCountry = new Select(driver.findElement(By.id("PDim_PAR")));
                List<WebElement> partnerCountryList = partnerCountry.getOptions();


                for (int ab = 0; ab< partnerCountryList.size(); ab++)
                {
                    Select partnerCountry2 = new Select(driver.findElement(By.id("PDim_PAR")));
                    List<WebElement> partnerCountryList2 = partnerCountry2.getOptions();

                    if (partnerCountryList2.get(ab).getText().trim().equals( countryWithCode[a].trim()))
                    {
                        System.out.println("Starting Data Download Process");
                        System.out.println("Country "+ partnerCountryList2.get(ab).getText());
                        partnerCountry2.selectByValue(partnerCountryList2.get(ab).getAttribute("value"));

                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HDimName > b:nth-child(1) > a:nth-child(1)")));
                        WebElement setTime =  driver.findElement(By.cssSelector(".HDimName > b:nth-child(1) > a:nth-child(1)"));
                        actions.doubleClick(setTime).perform();
                        TimeUnit.SECONDS.sleep(25);

                        driver.switchTo().frame("DialogFrame");
                        driver.switchTo().frame("TimeSelector");
                        Select fromDrpDwn = new Select(driver.findElement(By.id("cboAnnualFrom")));
                        fromDrpDwn.selectByValue("1988");

                        driver.switchTo().defaultContent();
                        driver.switchTo().frame("DialogFrame");
                        driver.findElement(By.id("lbtnViewData")).click();

                        driver.switchTo().defaultContent();
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));


                        if (opts.size() > 0)
                        {
                            for (int l = 0; l < opts.size(); l++) {
                                if (countryArray[a].trim().equals("Spain") && l==0)
                                {
                                    l = 3;
                                }if (countryArray[a].trim().equals("Slovenia") && l==0)
                                {
                                    l = 32;
                                }
                                try {
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                                    setIndustry(wait, driver, l);
                                } catch (NoSuchElementException errorIndustryDrpDwn){
                                    System.out.println("Error Log : Industry Drop Down Not Found! Trying again in 30 seconds.");
                                    TimeUnit.SECONDS.sleep(60);
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                                    setIndustry(wait, driver, l);
                                }
                                TimeUnit.SECONDS.sleep(20);

                                // If the error containing the word error occurs, reload the page and re do from the same index.
                                if (driver.findElements( By.id("_ctl0__ctl0_cphCentre_ContentPlaceHolder1__ctl1_divErrorMessage") ).size() != 0 && driver.findElement(By.id("_ctl0__ctl0_cphCentre_ContentPlaceHolder1__ctl1_divErrorMessage")).getText().contains("error"))
                                {

                                    //Set Primary Country
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_COU")));
                                    Select countryDrpDwn2 = new Select(driver.findElement(By.id("PDim_COU")));
                                    countryDrpDwn2.selectByValue("35~GBR");
                                    TimeUnit.SECONDS.sleep(25);

                                    // Set Secondary Country
                                    partnerCountry.selectByValue(partnerCountryList.get(ab).getAttribute("value"));

                                    //set Time Period
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".HDimName > b:nth-child(1) > a:nth-child(1)")));
                                    WebElement setTime2 =  driver.findElement(By.cssSelector(".HDimName > b:nth-child(1) > a:nth-child(1)"));
                                    actions.doubleClick(setTime2).perform();
                                    TimeUnit.SECONDS.sleep(25);

                                    driver.switchTo().frame("DialogFrame");
                                    driver.switchTo().frame("TimeSelector");
                                    Select fromDrpDwn2 = new Select(driver.findElement(By.id("cboAnnualFrom")));
                                    fromDrpDwn2.selectByValue("1988");

                                    driver.switchTo().defaultContent();
                                    driver.switchTo().frame("DialogFrame");
                                    driver.findElement(By.id("lbtnViewData")).click();

                                    TimeUnit.SECONDS.sleep(60);
                                    // Set Industry
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                                    try {
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                                        setIndustry(wait, driver, l);
                                    } catch (NoSuchElementException errorIndustryDrpDwn){
                                        System.out.println("Error Log : Industry Drop Down Not Found! Trying again in 30 seconds.");
                                        TimeUnit.SECONDS.sleep(60);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
                                        setIndustry(wait, driver, l);
                                    }
                                }
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menubar-export > a:nth-child(1)")));
                                try {
                                    WebElement exportBtn = driver.findElement(By.cssSelector("#menubar-export > a:nth-child(1)"));
                                    actions.doubleClick(exportBtn).perform();
                                    TimeUnit.SECONDS.sleep(2);
                                } catch (NoSuchElementException noExportBtn) {
                                    System.out.println("Error Log : Export Button Not Found! Trying again in 30 seconds.");
                                    TimeUnit.SECONDS.sleep(30);
                                    WebElement exportBtn = driver.findElement(By.cssSelector("#menubar-export > a:nth-child(1)"));
                                    actions.doubleClick(exportBtn).perform();
                                    TimeUnit.SECONDS.sleep(2);
                                }


                                wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("menuitemExportExcel"))));
                                try {
                                    driver.findElement(By.id("menuitemExportExcel")).click();
                                    TimeUnit.SECONDS.sleep(20);
                                } catch (NoSuchElementException errorMenuItem) {
                                    System.out.println("Error Log : Menu Item Not Found! Trying again in 30 seconds.");
                                    TimeUnit.SECONDS.sleep(30);
                                    driver.findElement(By.id("menuitemExportExcel")).click();
                                    TimeUnit.SECONDS.sleep(20);
                                }

                                try {
                                    driver.switchTo().frame("DialogFrame");
                                    try {
                                        startDownload(driver, actions);
                                    } catch (NoSuchFrameException er) {
                                        System.out.println("Error Log : Download Button Not Found! Trying again in 30 seconds.");
                                        TimeUnit.SECONDS.sleep(30);
                                        startDownload(driver, actions);
                                    }
                                }catch (NoSuchElementException err){
                                    System.out.println("Error Log : Switching to iFrame Failed! Trying again in 30 seconds.");
                                    TimeUnit.SECONDS.sleep(30);
                                    driver.switchTo().frame("DialogFrame");
                                    try {
                                        startDownload(driver, actions);
                                    } catch (NoSuchFrameException er) {
                                        System.out.println("Error Log : Download Button Not Found! Trying again in 30 seconds.");
                                        TimeUnit.SECONDS.sleep(30);
                                        startDownload(driver, actions);
                                    }
                                }
                            }
                        }
                    }
                }

        }

        }
//
//        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
//        ui-menu-0-0
    }

    private static void setIndustry(WebDriverWait wait, WebDriver driver, int i) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PDim_IND")));
        Select elementAgain = new Select(driver.findElement(By.id("PDim_IND")));
        List<WebElement> optionsAgain = elementAgain.getOptions();
        elementAgain.selectByValue(optionsAgain.get(i).getAttribute("value"));
        System.out.print("Element Id: "+i+" | Label: "+optionsAgain.get(i).getText().trim());
        System.out.println("Industry Size: "+optionsAgain.size());
    }

    private static void startDownload(WebDriver driver, Actions actions) throws InterruptedException {
        int i = 0;
        while (i == 0){
            try {
                System.out.println("Trying to Download");
                WebElement downloadBtn = driver.findElement(By.cssSelector("#btnExportToExcel"));
                // #btnExportToExcel
                actions.doubleClick(downloadBtn).perform();
                System.out.println("Clicked on Download Button");
                TimeUnit.SECONDS.sleep(30);
                driver.switchTo().defaultContent();
                System.out.println("Now in Main popup");
                try {
                    WebElement closeBtn = driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a"));
                    actions.doubleClick(closeBtn).perform();
                    System.out.println("   ==> SUCCESS");
                    i++;
                } catch (NoSuchElementException error){
                    TimeUnit.SECONDS.sleep(30);
                    WebElement closeBtn = driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a"));
                    actions.doubleClick(closeBtn).perform();
                    System.out.println("   ==> SUCCESS");
                    i++;
                }
            } catch (NoSuchElementException errorDownloadButton) {
                TimeUnit.SECONDS.sleep(30);
                System.out.println("Error Log : Download Button Not Found! Trying again in 30 seconds.");

                WebElement downloadBtn2 = driver.findElement(By.cssSelector("#btnExportToExcel"));
                actions.doubleClick(downloadBtn2).perform();
                TimeUnit.SECONDS.sleep(10);
                actions.doubleClick(downloadBtn2).perform();
                driver.switchTo().defaultContent();
                try {
                    WebElement closeBtn = driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a"));
                    actions.doubleClick(closeBtn).perform();
                    System.out.println("   ==> SUCCESS");
                    i++;
                } catch (NoSuchElementException error){
                    TimeUnit.SECONDS.sleep(30);
                    WebElement closeBtn = driver.findElement(By.cssSelector("body > div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-draggable > div.ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix > a"));
                    actions.doubleClick(closeBtn).perform();
                    System.out.println("   ==> SUCCESS");
                    i++;
                }
            }
        }
    }
}
