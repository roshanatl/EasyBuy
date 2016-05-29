<div class="span6">
    <div class="well">  
        
        <div class="form-group">
        <img src="images/mastercard.png" alt="Master Card"/> 
        <img src="images/visa.png" alt="Visa Express"/>     
        <img src="images/AEx.png" alt="American Express"/>
        <img src="images/discover.png" alt="Discover"/>
        <br/>
        </div>
        
        <div class="form-group">
            <label for="cardType">
                Select your Card
            </label>
            <select name ="cardType" id="cardType"  required="required" autofocus=""  >
                <option>Master Card</option>
                <option>Visa</option>
                <option>American Express</option>
                <option>Discover</option>
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
                Expires
            </label>
            <input type="text" name ="expiry" class="form-control" id="expiry"  placeholder="MM/YYYY" required="required"  />
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
    