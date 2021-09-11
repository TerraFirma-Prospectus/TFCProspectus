package net.dries007.tfc.common.capabilities;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import net.dries007.tfc.common.capabilities.heat.IHeat;

public interface DelegateHeatHandler extends IHeat
{
    IHeat getHeatHandler();

    @Override
    default float getTemperature()
    {
        return getHeatHandler().getTemperature();
    }

    @Override
    default void setTemperature(float temperature)
    {
        getHeatHandler().setTemperature(temperature);
    }

    @Override
    default float getHeatCapacity()
    {
        return getHeatHandler().getHeatCapacity();
    }

    @Override
    default float getForgingTemperature()
    {
        return getHeatHandler().getForgingTemperature();
    }

    @Override
    default float getWeldingTemperature()
    {
        return getHeatHandler().getWeldingTemperature();
    }

    @Override
    default void addTooltipInfo(ItemStack stack, List<Component> text)
    {
        getHeatHandler().addTooltipInfo(stack, text);
    }
}
