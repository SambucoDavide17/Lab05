package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CorsoDAO {
	
	public List<String> getTutteParole() {
		
		final String sql = "SELECT * FROM esami";
		
		List<String> parole = new LinkedList<String>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				parole.add(rs.getString("Nome"));
			}
			conn.close();
			return parole;
			
		} catch (SQLException e) {
		throw new RuntimeException("Errore DB", e);

		}
	}
}
