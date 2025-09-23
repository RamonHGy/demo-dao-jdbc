package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDao {
	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO department(Name)" + "VALUES(?) ";
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, obj.getName());

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		String sql = "UPDATE department SET Name = ? WHERE id = ? ";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, obj.getName());
			pst.setInt(2, obj.getId());
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		String sql = "DELETE FROM department WHERE Id = ?";

		try {
			pst = conn.prepareStatement(sql);

			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql = "SELECT * FROM department WHERE Id = ? ";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				return dep;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		PreparedStatement pst = null;
		String sql = "SELECT * FROM department ";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();

			List<Department> list = new ArrayList<>();
			while(rs.next()) {
				Department dep = instantiateDepartment(rs);
				list.add(dep);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setId(rs.getInt("Id"));
		department.setName(rs.getString("Name"));
		return department;
	}

}
