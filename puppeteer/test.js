const puppeteer = require('puppeteer');
(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    try{
    await page.goto('https://8081-dccababfafedaccdcacccdeebadffeffbdaafcddfbdadfead.examlyiopb.examly.io/');
    await page.setViewport({
      width:1200,
      height:800,
    })
      await page.click('#signupLink');
      await page.waitForNavigation();
      await page.type('#email', 'test@gmail.com');
      await page.type('#username', 'testuser');
      await page.type('#mobileNumber', '9876543210');
      await page.type('#password', 'Test@123');
      await page.type('#confirmPassword', 'Test@123');
      await page.click('#submitButton');
      await page.waitForNavigation();
      await page.waitForSelector('#loginBox',{timeout:3000});
      console.log('TESTCASE:FE_Signup:success');
    }
     catch(e){
      console.log('TESTCASE:FE_Signup:failure');
    }finally{
      await page.close();
      await browser.close();
    }
    
})();

 

(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    try{
    await page.goto('https://8081-dccababfafedaccdcacccdeebadffeffbdaafcddfbdadfead.examlyiopb.examly.io/');
    await page.setViewport({
      width:1200,
      height:800,
    })
      await page.type('#email', 'test@gmail.com');
      await page.type('#password', 'Test@123');
      await page.click('#loginButton');
      await page.waitForNavigation();
      await page.waitForSelector('#homeButton',{timeout:3000});
      console.log('TESTCASE:FE_login:success');
    }
     catch(e){
      console.log('TESTCASE:FE_login:failure');
    }finally{
      await page.close();
      await browser.close();
    }
    
})();

 

(async () => {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    try{
    await page.goto('https://8081-dccababfafedaccdcacccdeebadffeffbdaafcddfbdadfead.examlyiopb.examly.io/');
    await page.setViewport({
      width:1200,
      height:800,
    })
    await page.type('#email', 'test@gmail.com');
    await page.type('#password', 'Test@123');
    await page.click('#loginButton');
      await page.waitForNavigation();
      await page.waitForSelector('#homeButton',{timeout:3000});
      await page.click('#grid1');
      await page.waitForSelector('#submitButton',{timeout:3000});
      await page.click('#jobsButton');
      await page.waitForSelector('#appliedJobs',{timeout:3000});
      console.log('TESTCASE:FE_userOperation:success');
    }
     catch(e){
      console.log('TESTCASE:FE_userOperation:failure');
    }finally{
      await page.close();
      await browser.close();
    }
    
})();

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  try{
  await page.goto('https://8081-dccababfafedaccdcacccdeebadffeffbdaafcddfbdadfead.examlyiopb.examly.io/');
  await page.setViewport({
    width:1200,
    height:800,
  })
    await page.type('#email', 'hr@gmail.com');
    await page.type('#password', 'HR@123');
    await page.click('#loginButton');
    await page.waitForNavigation();
    await page.waitForSelector('#allJobsadmin',{timeout:3000});
    await page.click('#grid1');
    await page.waitForSelector('#updateButton',{timeout:3000});
    console.log('TESTCASE:FE_HROperation:success');
  }
   catch(e){
    console.log('TESTCASE:FE_HROperation:failure');
  }finally{
    await page.close();
    await browser.close();
  }
  
})();

(async () => {
  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  try{
  await page.goto('https://8081-dccababfafedaccdcacccdeebadffeffbdaafcddfbdadfead.examlyiopb.examly.io/');
  await page.setViewport({
    width:1200,
    height:800,
  })
    await page.type('#email', 'admin@gmail.com');
    await page.type('#password', 'Admin@123');
    await page.click('#loginButton');
    await page.waitForNavigation();
    await page.waitForSelector('#adminHome',{timeout:3000});
    await page.click('#addButton');
    await page.waitForSelector('#enterName',{timeout:3000});
    await page.click('#logoutButton');
    await page.waitForSelector('#loginBox',{timeout:3000});
    console.log('TESTCASE:FE_AdminOperation:success');
  }
   catch(e){
    console.log('TESTCASE:FE_AdminOperation:failure');
  }finally{
    await page.close();
    await browser.close();
  }
  
})();