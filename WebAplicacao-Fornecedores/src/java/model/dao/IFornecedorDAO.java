package model.dao;

import util.db.exception.NegocioException;
import util.db.exception.PersistenciaException;
import java.util.List;
import model.domain.Fornecedor;


public interface IFornecedorDAO {
    boolean editar(Fornecedor fornecedor) throws PersistenciaException, NegocioException;
    Fornecedor consultarPorCodigo(Integer cod) throws PersistenciaException;
    List<Fornecedor> exibirTodos() throws PersistenciaException;
    boolean excluir(Integer id) throws PersistenciaException;
    boolean adicionar(Fornecedor fornecedor) throws PersistenciaException, NegocioException;
}
