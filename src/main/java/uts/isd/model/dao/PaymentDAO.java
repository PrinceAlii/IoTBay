package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import uts.isd.model.User;
import com.mysql.cj.xdevapi.PreparableStatement;

public class PaymentDAO {

    private Statement st;
    private PreparableStatement readSt;

    public PaymentDAO (Connection connection) throws SQLException {
        connection.setAutoCommit(true);
        st = connection.createStatement();
    }

    // add payment details to the database
    public void addPaymentDetails(int userID, boolean savedPaymentDetails, String paymentCardDetails, String PaymentMethod) throws SQLException {
        st.executeUpdate("INSERT INTO IOTBAY.paymentdetails (userID, savedPaymentDetails, paymentCardDetails, paymentMethod)" + "VALUES('" + userID + "', '" + savedPaymentDetails + "', '" + paymentCardDetails + "', '" + PaymentMethod + "')");
    }

    // delete payment details using paymentID
    public void deletePaymentDetails(int paymentID) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.paymentdetails WHERE paymentID='" + paymentID + "'");
    }

    // update payment details using paymentID
    public void updatePayment(int paymentID, boolean savedPaymentDetails, String paymentCardDetails, String paymentMethod) throws SQLException {
        st.executeUpdate("UPDATE IOTBAY.paymentdetails SET savedPaymentDetails='" + savedPaymentDetails + "', paymentCardDetails='" + paymentCardDetails + "' paymentMethod ='" + paymentMethod + "' WHERE paymentID ='" + paymentID + "'");
    }
}
