package com.base;

import java.awt.Robot;
import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {

	public static WebDriver driver;

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING BROWSER LAUNCH");
		}
	}

	protected static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING BROWSER LAUNCH");
		}
	}

	protected static void titleOfPage() {
		try {
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING GETTING PAGE TITLE OR GETTING URL");
		}
	}
	
	protected static void passInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING VALUE PASSING");
		}
		
		
	}

	protected static void takeScreenShots() {
		try {
			Date currentDate = new Date();
			String replace = currentDate.toString().replace(" ", "_").replace(":", "_");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File(".//Screenshots//" + replace + ".png"));
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING TAKING SCREENSHOT");
		}

	}

	protected static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING CLICKING ON BUTTON");
		}
	}

	protected static void navigation(String navigate) {
		try {
			if (navigate.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (navigate.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (navigate.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATION");
		}
	}

	protected static void closeOrQuit(String type) {
		try {
			if (type.equalsIgnoreCase("close")) {
				driver.close();
			} else if (type.equalsIgnoreCase("quit")) {
				driver.quit();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WINDOW CLOSE/QUIT");
		}

	}

	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING GETTING TEXT");
		}
	}

	protected static void simpleDismissAlert(String type) {
		try {
			Alert alert = driver.switchTo().alert();
			if (type.equalsIgnoreCase("accept")) {
				String text = alert.getText();
				System.out.println(text);
				alert.accept();
			} else if (type.equalsIgnoreCase("dismiss")) {
				String text = alert.getText();
				System.out.println(text);
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING SIMPLE ALERT");
		}
	}

	protected static void promptAlert(String value) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING PROMPT ALERT");
		}
	}

	protected static void actionMethod(WebElement element, String type) {
		try {
			Actions action = new Actions(driver);
			if (type.equalsIgnoreCase("click")) {
				action.click(element).perform();
			} else if (type.equalsIgnoreCase("right click")) {
				action.contextClick(element).perform();
			} else if (type.equalsIgnoreCase("double click")) {
				action.doubleClick(element).perform();
			} else if (type.equalsIgnoreCase("move to element")) {
				action.moveToElement(element);
			}
		} catch (Exception e) {
			Assert.fail("ERROR: DURING ACTION CLASS");
		}
	}

	protected void robotMethod(String action, int num) {
        try {
			Robot robot = new Robot();
			robot.keyPress(num);
			robot.keyRelease(num);		
		} catch (Exception e) {
			Assert.fail("ERROR: DURING ROBOT CLASS");
		}
	}
	
	protected void explicitWait(WebElement element, int seconds, String type) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			if (type.equalsIgnoreCase("element visible")) {
				wait.until(ExpectedConditions.visibilityOf(element));
			}else if (type.equalsIgnoreCase("clickable")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}else if (type.equalsIgnoreCase("selected")) {
				wait.until(ExpectedConditions.elementToBeSelected(element));
			}else if (type.equalsIgnoreCase("Check Alert")) {
				wait.until(ExpectedConditions.alertIsPresent());			
			}
			} catch (Exception e) {
			Assert.fail("ERROR: OCCURS DURING WAIT");
		}
	}
	
	protected static void isSelected(WebElement element) {
		try {
			 boolean selected = element.isSelected();
			 System.out.println(selected);
		} catch (Exception e) {
			Assert.fail("Error: during isSelected check");
		}
	}
	
	protected static void isEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			 System.out.println(enabled);
		} catch (Exception e) {
			Assert.fail("Error: during isEnabled check");
		}
	}
	
	protected static void isDisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println(displayed);
		} catch (Exception e) {
			Assert.fail("Error: during isDisplayed check");
		}
	}
	
	protected void getOptions(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			System.out.println(options);
		} catch (Exception e) {
			Assert.fail("Error: During getting dropdown options");
		}
	}
	
	protected void getFirstSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption);
		} catch (Exception e) {
			Assert.fail("Error: During First selected dropdown option");
		}
	}
	
	protected void allSelectedOption(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			System.out.println(allSelectedOptions);
		} catch (Exception e) {
			Assert.fail("Error: During all selected dropdown options");
		}
	}
	
	protected void isMultiple(WebElement element) {
		try {
			Select select = new Select(element);
			boolean multiple = select.isMultiple();
			System.out.println(multiple);
		} catch (Exception e) {
			Assert.fail("Error: During checking the dropdown have multiple selected options");
		}
	}
	
	protected static void javaScriptMethod(WebElement element, String type) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			if (type.equalsIgnoreCase("scroll into view")) {
				js.executeScript("arguments[0].scrollIntoView(true);", element);
				if (type.equalsIgnoreCase("scroll down")) {
					js.executeScript("window.scrollBy(0,500)");
				}else if (type.equalsIgnoreCase("scroll up")) {
					js.executeScript("window.scrollBy(0,-500)");
				}else if (type.equalsIgnoreCase("sendKeys")) {
					js.executeScript("arguments[0].setAttribute('value','Amitesh');",element);
				}else if (type.equalsIgnoreCase("click")) {
					js.executeScript("arguments[0].click()", element);
				}
			}
		} catch (Exception e) {
			Assert.fail("ERROR:DURING JAVASCRIPT");
		}
	}
		

}
