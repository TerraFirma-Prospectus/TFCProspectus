/*
 * Work under Copyright. Licensed under the EUPL.
 * See the project README.md and LICENSE.txt for more information.
 */

package net.dries007.tfc.compat.waila.providers;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.compat.waila.interfaces.IWailaBlock;
import net.dries007.tfc.objects.blocks.agriculture.BlockBerryBush;
import net.dries007.tfc.util.calendar.Month;

public class BerryBushProvider implements IWailaBlock
{
    @Nonnull
    @Override
    public List<String> getBodyTooltip(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull List<String> currentTooltip, @Nonnull NBTTagCompound nbt)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof BlockBerryBush)
        {
            currentTooltip.add(new TextComponentTranslation("waila.tfc.agriculture.harvesting_months").getFormattedText());
            BlockBerryBush block = (BlockBerryBush) state.getBlock();
            for (Month month : Month.values())
            {
                if (block.bush.isHarvestMonth(month))
                {
                    currentTooltip.add(TerraFirmaCraft.getProxy().getMonthName(month, true));
                }
            }
        }
        return currentTooltip;
    }

    @Nonnull
    @Override
    public List<Class<?>> getBodyClassList()
    {
        return Collections.singletonList(BlockBerryBush.class);
    }
}
