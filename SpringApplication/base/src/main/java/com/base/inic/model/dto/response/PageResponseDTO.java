package com.base.inic.model.dto.response;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.base.inic.model.dto.request.PageRequestDTO;

/**
 * common-used response class used to return List data to browser by spring controllers.
 * @date 2017/6/6.
 * @author netyjq@gmail.com
 */
@Data
public class PageResponseDTO<T> implements Serializable {

    /**
     * coleção de dados
     */
    private List<T> content;

    /**
     * Número total de registros do banco de dados
     */
    private long total = 0;

    /**
     * número de página
     */
    private long pageNo = 1;

    /**
     * Tamanho dos dados por página
     */
    private long pageSize = 1;

    /**
     * total de páginas
     */
    private long totalPage = 1;

    public PageResponseDTO<T> empty(PageRequestDTO baseDTO) {
        this.setPageSize(baseDTO.getPageSize());
        this.setPageNo(baseDTO.getPageNum());
        this.setTotal(0);
        this.setTotalPage(0);
        this.setContent(new ArrayList<T>());
        return this;
    }

    public PageResponseDTO(List<T> content, long total, long pageNo, long pageSize) {
        this.content = content;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalPage = getTotalPage();
    }

    public PageResponseDTO(List<T> content, long total, PageRequestDTO baseDTO) {
        this.content = content;
        this.total = total;
        this.pageNo = baseDTO.getPageNum();
        this.pageSize = baseDTO.getPageSize();
    }

    public List<T> getContent() {
        if(this.content == null){
            this.content = new ArrayList<T>();
        }
        return content;
    }

    public PageResponseDTO<T> setContent(List<T> content) {
        this.content = content;
        return this;
    }


    public PageResponseDTO<T> setTotal(long total) {
        this.total = total;
        return this;
    }


    public PageResponseDTO<T> setPageNo(long pageNo) {
        this.pageNo = pageNo;
        return this;
    }


    public PageResponseDTO<T> setPageSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalPage() {
        if (this.total == 0 || this.total < pageSize) {
            this.totalPage = 1;
        } else {
            this.totalPage = this.total % pageSize == 0 ? this.total / this.pageSize : (this.total / this.pageSize) + 1;
        }
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageResponseDTO{" +
                "content=" + content +
                ", total=" + total +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
