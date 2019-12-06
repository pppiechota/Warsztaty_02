package com.piotrpiechota;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try (final Connection conn = DBUtil.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
