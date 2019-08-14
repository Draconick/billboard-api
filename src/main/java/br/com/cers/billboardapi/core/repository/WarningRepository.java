package br.com.cers.billboardapi.core.repository;

import org.springframework.stereotype.Repository;

import br.com.cers.billboardapi.core.model.Warning;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface WarningRepository extends JpaRepository<Warning, Long> {

}
