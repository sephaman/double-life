/**
 * 
 */
package com.doublelife.doublelife.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.doublelife.doublelife.data.BetComp.retrievedBetData.InflatedMarketPrices;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.ArrayOfInt;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetAllMarkets;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetAllMarketsErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetAllMarketsReq;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetAllMarketsResp;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarket;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketPricesCompressed;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketPricesCompressedReq;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketPricesCompressedResp;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketPricesErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketReq;
import com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.GetMarketResp;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.APIRequestHeader;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.EventType;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.GetAllEventTypes;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.GetEventTypesReq;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.GetEventTypesResp;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.GetEventsErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.Login;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LoginErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LoginReq;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LoginResp;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.Logout;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LogoutErrorEnum;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LogoutReq;
import com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.LogoutResp;
import com.doublelife.doublelife.services.BetDataRetrieverService;

/**
 * Service implementation of BetDataRetrieverService.
 * @author Joseph McAleer
 *
 */
public class BFBetDataRetrieverServiceImpl implements BetDataRetrieverService {

	private final Logger logger = LoggerFactory.getLogger(BFBetDataRetrieverServiceImpl.class);
	
	private BFExchangeServiceStub stub_AUS;
	private BFGlobalServiceStub stub_global;
	private String username = "sephaman";
	private String password = "Brownmouse92";
	private String sessionToken = "";
	private final static int AFL_ID = 61420;
	
	
	public BFBetDataRetrieverServiceImpl() {
		connectGlobalService();
	}
	
	private void connectExchangeService() {
		if (this.stub_AUS == null) {
			try {
				stub_AUS = new BFExchangeServiceStub("https://api-au.betfair.com/exchange/v5/BFExchangeService");
	
				stub_AUS._getServiceClient().getOptions().setTimeOutInMilliSeconds(20 * 1000); 
				stub_AUS._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.MC_ACCEPT_GZIP, "true");
				stub_AUS._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.MC_GZIP_RESPONSE, "true");
				} catch (Exception ex) {
					logger.info("error initialising bet exchange " + ex.getMessage());
				}
			}
	}
	
	private void connectGlobalService() {
			if (stub_global == null)
			{
				try {
				stub_global = new BFGlobalServiceStub("https://api.betfair.com/global/v3/BFGlobalService");

				// You may set up the connection parameters of the stub here if necessary
		        // For example: Wait 20 seconds for a response from the API
				stub_global._getServiceClient().getOptions().setTimeOutInMilliSeconds(20 * 1000);
				stub_global._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.MC_ACCEPT_GZIP, "true");
				stub_global._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.MC_GZIP_RESPONSE, "true");
				} catch (Exception ex) {
					logger.info("error initialising bet exchange " + ex.getMessage());
				}
			}
		}
	
	// Fire a Web services login request
		public void login() throws Exception {
			// Create a login request object
	        LoginReq request = new LoginReq();
	        
	        // Set the parameters you wish to pass the the API
	        request.setUsername(username);
	        request.setPassword(password);
	        request.setProductId(82); // 82 is the standard Free Access API
	        request.setIpAddress(""); // Does not need to be set, but may not be null so use an empty string.

	        // Create the Login message and attach the request to it.
	        Login msg = new Login();
	        msg.setRequest(request);
	        
	        // Send the request to the Betfair Service.
	        LoginResp resp = stub_global.login(msg).getResult();
	        
	        // Transfer the response data back to the API context
	        logger.info("login response:" + resp.getHeader());
	        
	        // Check the response code, and throw and exception if the call failed
	        if (resp.getErrorCode() != LoginErrorEnum.OK)
	        {
	        	throw new IllegalArgumentException("Failed to log in: " + resp.getErrorCode() + " Minor Error:" + resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
	        }
	        
	        //set the session token
	        sessionToken = resp.getHeader().getSessionToken();
		}
	
	public InflatedMarketPrices getMarketPrices(int marketId) throws Exception {
		// Create a request object
		connectExchangeService();
		GetMarketPricesCompressedReq request = new GetMarketPricesCompressedReq();
        request.setHeader(getExchangeHeader());
        
        // Set the parameters
        request.setMarketId(marketId);

        // Create the message and attach the request to it.
        GetMarketPricesCompressed msg = new GetMarketPricesCompressed();
        msg.setRequest(request);
        
        // Send the request to the Betfair Exchange Service.
        GetMarketPricesCompressedResp resp = stub_AUS.getMarketPricesCompressed(msg).getResult();

        // Check the response code, and throw and exception if call failed
        if (resp.getErrorCode() != GetMarketPricesErrorEnum.OK)
        {
        	throw new IllegalArgumentException("Failed to retrieve data: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
        	
        }
        // Transfer the response data back to the API context
        sessionToken = resp.getHeader().getSessionToken();

        return new InflatedMarketPrices(resp.getMarketPrices());
	}
	
	
	public void getMarketData(int marketId) throws Exception {
		connectExchangeService();
		GetMarketReq request = new GetMarketReq();
        request.setHeader(getExchangeHeader());
        
        // Set the parameters
        request.setMarketId(marketId);

        // Create the message and attach the request to it.
        GetMarket msg = new GetMarket();
        msg.setRequest(request);
        
        // Send the request to the Betfair Exchange Service.
        GetMarketResp resp = stub_AUS.getMarket(msg).getResult();

        // Check the response code, and throw and exception if call failed
        if (resp.getErrorCode() != GetMarketErrorEnum.OK)
        {
        	throw new IllegalArgumentException("Failed to retrieve data: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
        	
        }
        // Transfer the response data back to the API context
        sessionToken = resp.getHeader().getSessionToken();

	}
	
	public void getAllMarketsData() throws Exception {
		connectExchangeService();
		GetAllMarketsReq request = new GetAllMarketsReq();
        request.setHeader(getExchangeHeader());
        
        // Create the message and attach the request to it.
        GetAllMarkets msg = new GetAllMarkets();
        msg.setRequest(request);
        
        // Send the request to the Betfair Exchange Service.
        GetAllMarketsResp resp = stub_AUS.getAllMarkets(msg).getResult();

        // Check the response code, and throw and exception if call failed
        if (resp.getErrorCode() != GetAllMarketsErrorEnum.OK)
        {
        	throw new IllegalArgumentException("Failed to retrieve data: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
        	
        }
        // Transfer the response data back to the API context
        sessionToken = resp.getHeader().getSessionToken();
	}
	
	public void getAllMarketsData(ArrayOfInt eventTypeIds) throws Exception {
		connectExchangeService();
		GetAllMarketsReq request = new GetAllMarketsReq();
        request.setHeader(getExchangeHeader());
        request.setEventTypeIds(eventTypeIds);
        
        // Create the message and attach the request to it.
        GetAllMarkets msg = new GetAllMarkets();
        msg.setRequest(request);
        
        // Send the request to the Betfair Exchange Service.
        GetAllMarketsResp resp = stub_AUS.getAllMarkets(msg).getResult();

        // Check the response code, and throw and exception if call failed
        if (resp.getErrorCode() != GetAllMarketsErrorEnum.OK)
        {
        	throw new IllegalArgumentException("Failed to retrieve data: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
        }
        // Transfer the response data back to the API context
        sessionToken = resp.getHeader().getSessionToken();
        
        int numOccurrences = StringUtils.countOccurrencesOf(resp.getMarketData(), "Match Odds"); 
        
        logger.info("Num matches: " + numOccurrences);
        
	}
	
	public void getAllEventsData() throws Exception {
		connectExchangeService();
		GetEventTypesReq request = new GetEventTypesReq();
        request.setHeader(getGlobalHeader());
        
        // Create the message and attach the request to it.
        GetAllEventTypes msg = new GetAllEventTypes();
        msg.setRequest(request);
        
        // Send the request to the Betfair Exchange Service.
        GetEventTypesResp resp = stub_global.getAllEventTypes(msg).getResult();

        // Check the response code, and throw and exception if call failed
        if (resp.getErrorCode() != GetEventsErrorEnum.OK)
        {
        	throw new IllegalArgumentException("Failed to retrieve data: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
        }
        // Transfer the response data back to the API context
        sessionToken = resp.getHeader().getSessionToken();
         
        for (EventType thisEvent : resp.getEventTypeItems().getEventType()) {
        	logger.info(thisEvent.getId() + " - " + thisEvent.getName());
        }
        
        
	}
	
	public BFExchangeServiceStub getExchangeConnection() {
		return stub_AUS;
	}
	
	/**
	 * @see com.doublelife.doublelife.services.BetDataRetrieverService#getMarkets()
	 */
	@Override
	public void getMarkets() {
		// TODO Auto-generated method stub
		
	}

	private com.doublelife.doublelife.data.webServices.generated.global.BFGlobalServiceStub.APIRequestHeader getGlobalHeader() {
        APIRequestHeader header = new APIRequestHeader();
        // The header must have the session token attached.
        header.setSessionToken(sessionToken);
        return header;
	}
	
	private com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.APIRequestHeader getExchangeHeader() {
		com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.APIRequestHeader
		header = new com.doublelife.doublelife.data.webServices.generated.exchange.BFExchangeServiceStub.APIRequestHeader();
        // The header must have the session token attached.
        header.setSessionToken(sessionToken);
        return header;
	}
	
	// Fire a Web services logout request
		public void logout() throws Exception {
			// Create a request object
	        LogoutReq request = new LogoutReq();
	        request.setHeader(getGlobalHeader());

	        // Create the Logout message and attach the request to it.
	        Logout msg = new Logout();
	        msg.setRequest(request);
	        
	        // Send the request to the Betfair Service.
	        LogoutResp resp = stub_global.logout(msg).getResult();
	       
	        // Transfer the response data back to the API context
	        logger.info("login response:" + resp.getHeader());
	        
	        // Check the response code, and throw and exception if the call failed
	        if (resp.getErrorCode() != LogoutErrorEnum.OK)
	        {
	        	throw new IllegalArgumentException("Failed to log out: "+resp.getErrorCode() + " Minor Error:"+resp.getMinorErrorCode()+ " Header Error:"+resp.getHeader().getErrorCode());
	        }
	        
	        sessionToken = resp.getHeader().getSessionToken();
		}

}
