/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.util;

import org.hibernate.dialect.MySQLInnoDBDialect;

/**
 *
 * @author depek
 */
public class LocalMysqlDialect extends MySQLInnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}