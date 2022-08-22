package fr.eni.springtpeniencheres.service.impl;

import fr.eni.springtpeniencheres.bo.Retrait;
import fr.eni.springtpeniencheres.repository.RetraitRepository;
import fr.eni.springtpeniencheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetraitServiceJpaImpl implements RetraitService {

    @Autowired
    private RetraitRepository retraitRepository;


    @Override
    public void addRetrait(Retrait retrait) throws Exception {

        retraitRepository.save(retrait);

    }

    @Override
    public Retrait getRetraitById(long id) {
        return retraitRepository.findById(id).get();
    }
}
