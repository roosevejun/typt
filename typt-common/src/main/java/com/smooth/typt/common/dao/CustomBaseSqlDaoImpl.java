package com.smooth.typt.common.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.smooth.typt.common.entity.PageModel;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomBaseSqlDaoImpl {
	
	@Autowired
	private EntityManager em;
	/**
	 * 处理sql语句
	 * 
	 * @param _strSql
	 * @return
	 */
	public String toSql(String _strSql) {
		String strNewSql = _strSql;

		if (strNewSql != null) {
			strNewSql = regReplace("'", "''", strNewSql);
		} else {
			strNewSql = "";
		}

		return strNewSql;
	}

	private String regReplace(String strFind, String strReplacement, String strOld) {
		String strNew = strOld;
		Pattern p = null;
		Matcher m = null;
		try {
			p = Pattern.compile(strFind);
			m = p.matcher(strOld);
			strNew = m.replaceAll(strReplacement);
		} catch (Exception e) {
		}

		return strNew;
	}
	
	/**
	 * 根据hql语句查询数据
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryForList(String hql, List<Object> params){
		Query query = em.createQuery(hql);
		List list = null;
		try {
			if(params != null && !params.isEmpty()){
				for(int i=0,size=params.size();i<size;i++){
					query.setParameter(i+1, params.get(i));
				}
			}
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByMapParams(String hql, Map<String, Object> params, Integer currentPage,Integer pageSize){
		//EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery(hql);
		List list = null;
		try {
			if(params != null && !params.isEmpty()){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			
			if(currentPage != null && pageSize != null){
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
			}
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public List queryByMapParams(String hql, Map<String, Object> params){
		return queryByMapParams(hql, params, null, null);
	}
	
	@SuppressWarnings("rawtypes")
	public List queryForList(String hql){
		return queryForList(hql, null);
	}
	
	/**
	 * 根据hql语句和分页条件查找分页数据
	 * @param hql
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PageModel queryForPage(String hql,int currentPage,int pageSize){
		PageModel page = new PageModel();
		List list = null;
		Integer totalCount = 0;
		Integer totalPage = 0; //总页数
		try {
			int firstResult = (currentPage-1)*pageSize;
			Query query = em.createQuery(hql);
			query.setMaxResults(pageSize);
			query.setFirstResult(firstResult);
			list = query.getResultList();
			
			Query query2 = em.createQuery(hql);
			List list2 = query2.getResultList();
			totalCount = (list2 == null) ? 0 : list2.size();
			if(totalCount % pageSize == 0){
				totalPage = totalCount/pageSize;
			}else{
				totalPage = totalCount/pageSize + 1;
			}
			
			page.setCurrentPage(currentPage);
			page.setList(list);
			page.setPageSize(pageSize);
			page.setTotalCount(totalCount);
			page.setTotalPage(totalPage);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}		
		return page;
	}
	
	/**
	 * 
	 * @param hql
	 * @param hqlCount  查询所有数据的hql
	 * @param params
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageModel queryForPageWithParams(String hql, String hqlCount, Map<String,Object> params, int currentPage,int pageSize){
		PageModel page = new PageModel();
		List<Object> list = null;
		Integer totalCount = 0;
		Integer totalPage = 0;
		
		//EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery(hql);
		
		try {
			
			if(params != null){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			
			query.setMaxResults(pageSize);
			query.setFirstResult((currentPage-1)*pageSize);
			list = query.getResultList();
			
			
			totalCount = this.queryCount(hqlCount, params).intValue();
			if(totalCount % pageSize == 0){
				totalPage = totalCount/pageSize;
			}else{
				totalPage = totalCount/pageSize + 1;
			}
			
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setList(list);
			page.setTotalCount(totalCount);
			page.setTotalPage(totalPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}			
		return page;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PageModel queryForPageWithParams(String hql,Map<String,Object> params, int currentPage,int pageSize){
		PageModel page = new PageModel();
		List<Object> list = null;
		Integer totalCount = 0;
		Integer totalPage = 0;
		
		//EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery(hql);
		
		try {
			
			if(params != null){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			
			query.setMaxResults(pageSize);
			query.setFirstResult((currentPage-1)*pageSize);
			list = query.getResultList();
			
			Query queryTotal = em.createQuery(hql);
			
			if(params != null){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					queryTotal.setParameter(entry.getKey(), entry.getValue());
				}
			}
			
			List<Object> totlaList = queryTotal.getResultList(); 
			totalCount = (totlaList == null) ? 0 : totlaList.size();
			if(totalCount % pageSize == 0){
				totalPage = totalCount/pageSize;
			}else{
				totalPage = totalCount/pageSize + 1;
			}
			
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setList(list);
			page.setTotalCount(totalCount);
			page.setTotalPage(totalPage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}			
		return page;
	}


	
	/**
	 * 查询总数
	 * @param hql
	 * @param params
	 * @return
	 */
	public Long queryCount(String hql, Map<String, Object> params){
		//EntityManager em = this.emf.createEntityManager();
		Query query = em.createQuery(hql);
		Long count = null;
		try{
			if(params != null && !params.isEmpty()){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			count = (Long) query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return count;
	}
	
	/**
	 * 查询总数
	 * @param sql
	 * @param params
	 * @return
	 */
	public Integer queryCountBySql(String sql, Map<String, Object> params){
		Integer count = null;
		try {
			Query query = em.createNativeQuery(sql);
			if(params != null && !params.isEmpty()){
				for(Map.Entry<String,Object> entry: params.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
			
			Object obj = query.getSingleResult();
			if(obj instanceof BigInteger){
				count = ((BigInteger) obj).intValue();
			}else{
				count = (Integer) obj;
			}
			 
		} finally {
			if(em != null){
				em.close();
			}
		}
		return count;
	}
	
	/**
	 * select count(*) from table 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeSql(String sql, List<Object> params){
		try {
			Query query = em.createNativeQuery(sql);
			if(params != null && !params.isEmpty()){
				for(int i = 0, size = params.size(); i < size; i++){
					query.setParameter(i+1, params.get(i));
				}
			}
			return query.executeUpdate();
		} finally {
			if(em != null){
				em.close();
			}
		}
	}
	

}
