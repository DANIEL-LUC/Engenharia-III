/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestao.dao;

import java.sql.Connection;

public abstract class AbstractDAO implements IDAO{
    protected Connection conn;
    protected boolean ctrlTransacao;
}
