
<div class="span6">
    <div class="well">  
        <%@include file="/Message.jsp" %>
        <div class="form-group">
        <img src="mastercard.png" alt="Master Card"/> 
        <img src="visa.png" alt="Visa Express"/>     
        <img src="AEx.png" alt="American Express"/>
        <img src="discover.png" alt="Discover"/>
        <br/>
        </div>
        
        <div class="form-group">
            <label for="cardType">
                Select your Card
            </label>
            <select name ="cardType" id="cardType"  required="required" autofocus=""  >
                <option value="">Select Card</option>
                <option value="Master">Master Card</option>
                <option value ="Visa" >Visa</option>
                <option value = "Amex">American Express</option>
                <option value = "Discover">Discover</option>
            </select> 
        </div>

        <div class="form-group">
            <label for="cardNum">
                Card Number
            </label>
            <input type="tel" name ="cardNum" class="form-control" id="cardNum"  placeholder="**** **** **** ****" required="required"  />
            <span class="card" aria-hidden="true"></span>
        </div>

        <div class="form-group">
            <label for="expiry">
                Expiry (MM/YYYY)
            </label>
            <input type="text" name ="expiry" class="form-control" id="expiry"  placeholder="MM / YY" required="required"  />
            <span class="card" aria-hidden="true"></span>
        </div>

        <div class="form-group">
            <label for="cvv">
                CVV
            </label>
            <input type="password" name ="cvv" class="form-control" id="expiry"  placeholder="CVV" required="required"  />
            <span class="card" aria-hidden="true"></span>
        </div>
    </div>
</div>
        

