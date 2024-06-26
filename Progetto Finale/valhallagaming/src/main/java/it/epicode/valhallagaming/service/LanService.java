//package it.epicode.valhallagaming.service;
//
//import it.epicode.valhallagaming.entity.Lan;
//import it.epicode.valhallagaming.repository.LanRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LanService {
//    @Autowired
//    private LanRepository lanRepository;
//
//    public List<Lan> findAll(){
//        return lanRepository.findAll();
//    }
//
//    public Optional<Lan> findById(Long id){
//        return lanRepository.findById(id);
//    }
//
//    public Lan save (Lan lan){
//        return lanRepository.save(lan);
//    }
//
//    public void deleteById (Long id){
//        lanRepository.deleteById(id);
//    }
//
//    public List<Lan> findAvailable(){
//        return lanRepository.findByAvailable(true);
//    }
//}
