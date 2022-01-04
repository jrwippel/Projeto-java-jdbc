package application;

import db.DB;

import java.sql.*;

public class ProgramUpdate {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = DB.getConnection();
			statement = connection.prepareStatement("UPDATE seller " +
					"SET BaseSalary = BaseSalary + ? " +
					"WHERE " +
					"(DepartmentId = ?)");
			statement.setDouble(1, 200);
			statement.setInt(2, 2);

			int rowsaffected = statement.executeUpdate();

			System.out.println("Done! Rows affected: "+ rowsaffected);


		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			DB.closeStatement(statement);
			DB.closeConnection();
		}
	}
}