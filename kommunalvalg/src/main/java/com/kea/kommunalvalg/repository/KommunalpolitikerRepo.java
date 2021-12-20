package com.kea.kommunalvalg.repository;

import com.kea.kommunalvalg.model.Kommunalpolitiker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KommunalpolitikerRepo extends JpaRepository<Kommunalpolitiker, Integer> {

    // Repo metode til at finde kommunalpolitikere fra et specifikt partinavn
    public List<Kommunalpolitiker> findAllByPartyName(String partyName);
    // // Repo metode til at finde kommunalpolitikere fra et specifikt partibogstav
    public List<Kommunalpolitiker> findAllByPartyShort(String partyShort);
}
