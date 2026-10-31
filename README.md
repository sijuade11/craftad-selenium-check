# CraftAd Selenium check (Java)

This small Maven project opens the deployed CraftAd frontend in Chrome and checks that the main heading is `Real trades. Clear prices.`

## Import into Eclipse

1. In Eclipse, choose **File → Import… → Maven → Existing Maven Projects**.
2. For **Root Directory**, browse to this `craftad-selenium-check` folder.
3. Make sure `pom.xml` is checked, then choose **Finish**.
4. If Eclipse asks to download Maven dependencies, allow it. Selenium Manager will arrange the matching browser driver when the program starts.
5. In Package Explorer, open `src/main/java → com.craftad → CraftAdHomeCheck.java`.
6. Right-click the file and choose **Run As → Java Application**.

Expected result: Chrome opens CraftAd, prints a `PASS` line in Eclipse's Console, and closes.

## What each part of the Java code is for

- `package com.craftad;` places this class in the project's `com.craftad` folder.
- The `import` lines let the class use Selenium's browser controls, its wait helper, and Java's clock duration type.
- `main` is the starting point Java runs when we choose **Java Application**.
- `new ChromeDriver()` opens Chrome and gives Selenium a handle to control it. Selenium Manager, included with modern Selenium, can locate or download the needed driver.
- `driver.get(...)` tells Chrome which page to open.
- `WebDriverWait` gives the page up to ten seconds to finish showing the heading instead of checking too early.
- `By.tagName("h1")` tells Selenium to look for the page's main heading element.
- `getText().trim()` reads the heading and removes extra spaces around it.
- The `if` statement compares the heading with the words we expect. If they differ, `AssertionError` marks the check as failed and explains why.
- `System.out.println(...)` prints the success message in Eclipse's Console.
- `finally` and `driver.quit()` close Chrome whether the check passes or fails.

## What the `pom.xml` does

- `groupId`, `artifactId`, and `version` give the project its name and version.
- `maven.compiler.release` asks Java to compile the code using Java 17 language rules.
- The `selenium-java` dependency tells Maven to fetch Selenium and the libraries it needs.
