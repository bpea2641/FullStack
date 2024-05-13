package com.example.fullstack.Repository;

import com.example.fullstack.Entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfoiloRepository extends JpaRepository<PortfolioEntity, Long> {

}
