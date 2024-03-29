package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.dtos.colordto.ColorCreateDto;
import backend.rentacar.entities.dtos.colordto.ColorUpdateDto;
import backend.rentacar.entities.dtos.colordto.ColorViewDto;
import backend.rentacar.repositories.abstracts.ColorRepository;
import backend.rentacar.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ColorManager implements ColorService {
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public ColorManager(ColorRepository colorRepository, ModelMapperService modelMapperService) {
        this.colorRepository = colorRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<ColorViewDto>> getAll() {
        List<Color> colors = this.colorRepository.findAll();
        List<ColorViewDto> result = colors.stream().map(color -> this.modelMapperService.forDto().map(color, ColorViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);
    }

    @Override
    public DataResult<List<ColorViewDto>> getAllByColorNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"colorName");
        List<Color> colors = this.colorRepository.findAll(sort);
        List<ColorViewDto> result = colors.stream().map(color -> this.modelMapperService.forDto().map(color, ColorViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.ColorMessages.COLOR_LISTED_BY_COLOR_NAME_ASC);  }

    @Override
    public DataResult<List<ColorViewDto>> getAllByColorNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"colorName");
        List<Color> colors = this.colorRepository.findAll(sort);
        List<ColorViewDto> result = colors.stream().map(color -> this.modelMapperService.forDto().map(color, ColorViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.ColorMessages.COLOR_LISTED_BY_COLOR_NAME_DESC);  }

    @Override
    public DataResult<ColorViewDto> add(ColorCreateDto colorCreateDto) {
        if(checkIfColorNameExists(colorCreateDto.getColorName())){
            return new ErrorDataResult<>(Messages.ColorMessages.COLOR_NAME_ALREADY_EXIST);
        }
        else{
        Color color = this.colorRepository.save(new Color(colorCreateDto.getColorName()));
        return new SuccessDataResult<>(ColorViewDto.of(color), Messages.GlobalMessages.DATA_ADDED);}
    }

    @Override
    public DataResult<ColorViewDto> update(int colorId, ColorUpdateDto colorUpdateDto) {
        if(checkIfColorIdExists(colorId)){
            return new ErrorDataResult<>(Messages.ColorMessages.COLOR_ID_NOT_FOUND);
        }
        else{
            Color color = this.colorRepository.findByColorId(colorId);
            color.setColorName(colorUpdateDto.getColorName());
            this.colorRepository.save(color);
            return new SuccessDataResult<>(ColorViewDto.of(color), Messages.GlobalMessages.DATA_UPDATED);
        }
    }

    @Override
    public DataResult<ColorViewDto> delete(int colorId) {
        if(checkIfColorIdExists(colorId)){
            return new ErrorDataResult<>(Messages.ColorMessages.COLOR_ID_NOT_FOUND);
        }
        else{
            Color color = this.colorRepository.findByColorId(colorId);
            this.colorRepository.deleteById(colorId);
            return new SuccessDataResult<>(ColorViewDto.of(color), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    @Override
    public DataResult<ColorViewDto> findByColorId(int colorId) {
        if(checkIfColorIdExists(colorId)){
            return new ErrorDataResult<>(Messages.ColorMessages.COLOR_ID_NOT_FOUND);
        }
        else{
        Color color = this.colorRepository.findByColorId(colorId);
        ColorViewDto result = this.modelMapperService.forDto().map(color, ColorViewDto.class);
        return new SuccessDataResult<>(result, Messages.ColorMessages.COLOR_LISTED_BY_COLOR_ID);  }}

    @Override
    public DataResult<ColorViewDto> findByColorName(String colorName) {
        if(!checkIfColorNameExists(colorName)){
            return new ErrorDataResult<>(Messages.ColorMessages.COLOR_NAME_NOT_FOUND);
        }
        else{
        Color color = this.colorRepository.findByColorName(colorName);
        ColorViewDto result = this.modelMapperService.forDto().map(color, ColorViewDto.class);
        return new SuccessDataResult<>(result, Messages.ColorMessages.COLOR_LISTED_BY_COLOR_NAME); } }

    private boolean checkIfColorNameExists(String colorName) {
        return this.colorRepository.existsByColorName(colorName);
    }
    private boolean checkIfColorIdExists(int colorId) {
        return !this.colorRepository.existsByColorId(colorId);
    }
}
